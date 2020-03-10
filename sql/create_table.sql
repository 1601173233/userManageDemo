

-- ----------------------------
-- Table structure for `auth`
-- ----------------------------
DROP TABLE IF EXISTS `auth`;
CREATE TABLE `auth` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `NAME` varchar(32) DEFAULT NULL COMMENT '权限名称',
  `MENU_ID` int(11) DEFAULT '0' COMMENT '菜单ID',
  `AUTH_TYPE` int(1) DEFAULT '0' COMMENT '权限类型：1.系统权限,2.菜单权限',
  `DEL_FLAG` int(1) DEFAULT '0' COMMENT '删除标志（0：未删除，1：已删除）',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATOR` int(11) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `MODIFIER` int(11) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='权限管理';

-- ----------------------------
-- Records of auth
-- ----------------------------

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `NAME` varchar(32) DEFAULT NULL COMMENT '部门名称',
  `ICON` varchar(32) DEFAULT NULL COMMENT '图标名称',
  `PARENT_ID` int(11) DEFAULT NULL COMMENT '父部门ID',
  `DISTRICT_ID` int(11) DEFAULT NULL COMMENT '所属行政区ID',
  `DEL_FLAG` int(1) DEFAULT '0' COMMENT '删除标志（0：未删除，1：已删除）',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATOR` int(11) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `MODIFIER` int(11) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='部门';

-- ----------------------------
-- Records of dept
-- ----------------------------

-- ----------------------------
-- Table structure for `dept_role`
-- ----------------------------
DROP TABLE IF EXISTS `dept_role`;
CREATE TABLE `dept_role` (
  `ID` int(11) NOT NULL COMMENT 'id',
  `DEPT_ID` int(11) DEFAULT NULL COMMENT '部门Id',
  `NAME` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `DEL_FLAG` int(1) DEFAULT '0' COMMENT '删除标志（0：未删除，1：已删除）',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATOR` int(11) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `MODIFIER` int(11) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门角色';

-- ----------------------------
-- Records of dept_role
-- ----------------------------

-- ----------------------------
-- Table structure for `dict`
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `NAME` varchar(32) DEFAULT NULL COMMENT '字典名称',
  `CODE` varchar(32) DEFAULT '0' COMMENT '字典类型编码',
  `PARENT_ID` int(1) DEFAULT '0' COMMENT '父字典ID',
  `DESCRIBES` varchar(100) DEFAULT '0' COMMENT '字典描述',
  `DEL_FLAG` int(1) DEFAULT '0' COMMENT '删除标志（0：未删除，1：已删除）',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATOR` int(11) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `MODIFIER` int(11) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='字典';

-- ----------------------------
-- Records of dict
-- ----------------------------

-- ----------------------------
-- Table structure for `dict_type`
-- ----------------------------
DROP TABLE IF EXISTS `dict_type`;
CREATE TABLE `dict_type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `NAME` varchar(32) DEFAULT NULL COMMENT '字典类型名称',
  `CODE` int(11) DEFAULT '0' COMMENT '字典类型编码',
  `DEL_FLAG` int(1) DEFAULT '0' COMMENT '删除标志（0：未删除，1：已删除）',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATOR` int(11) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `MODIFIER` int(11) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
-- Records of dict_type
-- ----------------------------

-- ----------------------------
-- Table structure for `district`
-- ----------------------------
DROP TABLE IF EXISTS `district`;
CREATE TABLE `district` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `NAME` varchar(32) DEFAULT NULL COMMENT '区域名称',
  `PARENT_ID` int(11) DEFAULT NULL COMMENT '区域ID',
  `DEL_FLAG` int(1) DEFAULT '0' COMMENT '删除标志（0：未删除，1：已删除）',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATOR` int(11) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `MODIFIER` int(11) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='区域管理';

-- ----------------------------
-- Records of district
-- ----------------------------

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `NAME` varchar(32) DEFAULT NULL COMMENT '菜单名称',
  `URL` varchar(200) DEFAULT NULL COMMENT '链接',
  `ICON` varchar(32) DEFAULT NULL COMMENT '图标名称',
  `PARENT_ID` int(11) DEFAULT NULL COMMENT '父菜单ID',
  `DEL_FLAG` int(1) DEFAULT '0' COMMENT '删除标志（0：未删除，1：已删除）',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATOR` int(11) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `MODIFIER` int(11) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for `operation_log`
-- ----------------------------
DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `AUTH_ID` varchar(32) DEFAULT NULL COMMENT '被操作者ID',
  `USER_ID` int(11) DEFAULT '0' COMMENT '操作ID',
  `OPERATION_TYPE` int(1) DEFAULT '0' COMMENT '操作类型:详细参见字典OPERATION_TYPE',
  `DEL_FLAG` int(1) DEFAULT '0' COMMENT '删除标志（0：未删除，1：已删除）',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATOR` int(11) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `MODIFIER` int(11) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
-- Records of operation_log
-- ----------------------------

-- ----------------------------
-- Table structure for `role_auth`
-- ----------------------------
DROP TABLE IF EXISTS `role_auth`;
CREATE TABLE `role_auth` (
  `AUTH_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `ROLE_ID` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`AUTH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色授权表';

-- ----------------------------
-- Records of role_auth
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `NAME` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `DEL_FLAG` int(1) DEFAULT '0' COMMENT '删除标志（0：未删除，1：已删除）',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATOR` int(11) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `MODIFIER` int(11) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for `use_dept`
-- ----------------------------
DROP TABLE IF EXISTS `use_dept`;
CREATE TABLE `use_dept` (
  `USER_ID` int(11) NOT NULL COMMENT '用户Id',
  `DEPT_ID` int(11) DEFAULT NULL COMMENT '单位id',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户的部门';

-- ----------------------------
-- Records of use_dept
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `USER_NAME` varchar(32) DEFAULT NULL COMMENT '用户名',
  `PASSWORD` varchar(32) DEFAULT NULL COMMENT '密码',
  `NICK` varchar(32) DEFAULT NULL COMMENT '昵称',
  `USER_TYPE` int(1) DEFAULT NULL COMMENT '用户类型（0：超管，1：普通用户）',
  `DEL_FLAG` int(1) DEFAULT '0' COMMENT '删除标志（0：未删除，1：已删除）',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATOR` int(11) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `MODIFIER` int(11) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of user
-- ----------------------------
