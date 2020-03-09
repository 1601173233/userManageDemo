package com.base.common.mybatis.config;//package com.suntek.common.mybatics.config;
//
//import java.io.IOException;
//import java.lang.reflect.Field;
//import java.com.base.common.util.ArrayList;
//import java.com.base.common.util.HashMap;
//import java.com.base.common.util.List;
//import java.com.base.common.util.Map;
//import java.com.base.common.util.Set;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.apache.ibatis.builder.xml.XMLMapperBuilder;
//import org.apache.ibatis.session.Configuration;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.stereotype.Component;
//
///**
// * Mybatics热部署
// *
// * @author : huangyujie
// * 2019/04/22 14:22:43
// */
//@Component
//public class RefreshMapperCache extends Thread {
//    private Log log = LogFactory.getLog(RefreshMapperCache.class);
//
//    /**
//     * mybatis的sessionFactory
//     */
//    @Autowired
//    private SqlSessionFactory sqlSessionFactory;
//
//    /**
//     * 扫描包路径配置
//     */
//    @Value("com/suntek/**/**/**Mapper.xml")
//    private String packageSearchPath;
//
//    private Resource[] mapperLocations;
//
//    /**
//     * 记录文件是否变化
//     */
//    private HashMap<String, Long> fileMapping = new HashMap<String, Long>();
//
//    /**
//     * 记录发生改变的xml文件名称
//     */
//    private List<String> changeResourceNameList = new ArrayList<String>();
//
//    /**
//     * 是否启动刷新
//     */
//    @Value("true")
//    private String isRefresh;
//
//    /**
//     * 每次执行的间隔
//     **/
//    private Integer sleepSeconds = 3;
//
//    /**
//     * 延迟刷新秒数
//     **/
//    private Integer delaySeconds = 5;
//
//    /**
//     * 构造函数
//     */
//    RefreshMapperCache() {
//        // 启动线程
//        this.start();
//    }
//
//    ;
//
//    /**
//     * 初始化方法
//     */
//    @Override
//    public void run() {
//        try {
//            //延迟执行的时间
//            Thread.sleep(delaySeconds * 1000);
//
//            if ("true".equalsIgnoreCase(isRefresh)) {
//
//                while (true) {
//                    refreshMapper();
//
//                    //延迟时间
//                    Thread.sleep(sleepSeconds * 1000);
//                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 延迟执行的时间
//     *
//     * @return
//     */
//    protected Integer getDelaySeconds() {
//        return delaySeconds;
//    }
//
//    /**
//     * 每次执行的间隔
//     *
//     * @return
//     */
//    protected Integer getSleepSeconds() {
//        return sleepSeconds;
//    }
//
//    /**
//     * 刷新的函数
//     */
//    protected void refreshMapper() {
//        try {
//            Configuration configuration = this.sqlSessionFactory.getConfiguration();
//
//            // step.1 扫描文件
//            try {
//                this.scanMapperXml();
//            } catch (IOException e) {
//                log.error("packageSearchPath扫描包路径配置错误");
//                return;
//            }
//
////            System.out.println("==============刷新前mapper中的内容 start===============");
////            //获取xml中的每个语句的名称即 id = "findUserById";
////            for (String name : configuration.getMappedStatementNames()) {
////                System.out.println(name);
////            }
////            System.out.println("==============刷新前mapper中的内容   end===============");
//
//            //清空被修改过后的文件名称，确保该集合是空的
//            changeResourceNameList.clear();
//
//            // step.2 判断是否有文件发生了变化
//            if (this.isChanged()) {
//                // step.2.1 清理
//                this.removeConfig(configuration);
//
//                // step.2.2 重新加载
//                for (Resource configLocation : mapperLocations) {
//                    try {
//                        //匹配被修改过的mapper文件，如果存在，则重新加载
//                        //如果想要重新加载全部mapper，可以不匹配
////                    	if(changeResourceNameList.contains(configLocation.getFilename())){
//                        XMLMapperBuilder xmlMapperBuilder
//                                = new XMLMapperBuilder(configLocation.getInputStream(),
//                                                       configuration, configLocation.toString(),
//                                                       configuration.getSqlFragments());
//                        xmlMapperBuilder.parse();
////                             System.out.println("mapper文件[" + configLocation.getFilename() + "]缓存加载成功");
////                    	}
//                    } catch (IOException e) {
//                        System.out.println("mapper文件[" + configLocation.getFilename() + "]不存在或内容格式不对");
//                        continue;
//                    }
//                }
//                //清空被修改过后的文件名称
//                changeResourceNameList.clear();
//            }
//
////            System.out.println("--------------------------刷新后mapper中的内容 start--------------------------");
////            for (String name : configuration.getMappedStatementNames()) {
////                System.out.println(name);
////            }
////            System.out.println("--------------------------刷新后mapper中的内容  end--------------------------");
//        } catch (Exception e) {
//            System.out.println("****************刷新缓存异常： " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     *
//     * @param packageSearchPath
//     */
//    public void setPackageSearchPath(String packageSearchPath) {
//        this.packageSearchPath = packageSearchPath;
//    }
//
//    /**
//     *
//     * @param sqlSessionFactory
//     */
//    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
//        this.sqlSessionFactory = sqlSessionFactory;
//    }
//
//    /**
//     * 扫描xml文件所在的路径
//     *
//     * @throws IOException
//     */
//    private void scanMapperXml() throws IOException {
//        //这个东西被我改了，这里如果注释掉就可以动态新增.xml文件了~
//        if (this.mapperLocations == null || this.mapperLocations.length == 0) {
//            this.mapperLocations = new PathMatchingResourcePatternResolver().getResources(packageSearchPath);
//        }
//    }
//
//    /**
//     * 清空Configuration中几个重要的缓存
//     *
//     * @param configuration
//     * @throws Exception
//     */
//    private void removeConfig(Configuration configuration) throws Exception {
//        Class<?> classConfig = configuration.getClass();
//        clearMap(classConfig, configuration, "mappedStatements");
//        clearMap(classConfig, configuration, "caches");
//        clearMap(classConfig, configuration, "resultMaps");
//        clearMap(classConfig, configuration, "parameterMaps");
//        clearMap(classConfig, configuration, "keyGenerators");
//        clearMap(classConfig, configuration, "sqlFragments");
//
//        clearSet(classConfig, configuration, "loadedResources");
//
//    }
//
//    @SuppressWarnings("rawtypes")
//    private void clearMap(Class<?> classConfig, Configuration configuration, String fieldName) throws Exception {
//        Field field = classConfig.getDeclaredField(fieldName);
//        field.setAccessible(true);
//        Map mapConfig = (Map) field.get(configuration);
//        mapConfig.clear();
//    }
//
//    @SuppressWarnings("rawtypes")
//    private void clearSet(Class<?> classConfig, Configuration configuration, String fieldName) throws Exception {
//        Field field = classConfig.getDeclaredField(fieldName);
//        field.setAccessible(true);
//        Set setConfig = (Set) field.get(configuration);
//        setConfig.clear();
//    }
//
//    /**
//     * 判断文件是否发生了变化
//     *
//     * @throws IOException
//     */
//    private boolean isChanged() throws IOException {
//        boolean flag = false;
////        System.out.println("***************************获取文件名   开始************************************");
//        for (Resource resource : mapperLocations) {
//            String resourceName = resource.getFilename();
//
////            System.out.println("resourceName == " + resourceName+",  path = "+resource.getURL().getPath());
//
//            boolean addFlag = !fileMapping.containsKey(resourceName);// 此为新增标识
//
//            // 修改文件:判断文件内容是否有变化
//            Long compareFrame = fileMapping.get(resourceName);
//            long lastFrame = resource.contentLength() + resource.lastModified();
//            boolean modifyFlag = null != compareFrame && compareFrame.longValue() != lastFrame;// 此为修改标识
//
//            if (addFlag) {
////            	System.out.println("            新增了：==="+ resourceName);
//            }
//            if (modifyFlag) {
////            	System.out.println("            修改了：==="+ resourceName);
//            }
//
//            // 新增或是修改时,存储文件
//            if (addFlag || modifyFlag) {
//                fileMapping.put(resourceName, Long.valueOf(lastFrame));// 文件内容帧值
//                flag = true;
//                changeResourceNameList.add(resourceName);
//            }
//        }
////        System.out.println("***************************获取文件名   结束************************************");
//        return flag;
//    }
//}