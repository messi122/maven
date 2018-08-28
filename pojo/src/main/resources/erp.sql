-- 基本参数
#基础参数设置
#key、value、name、remark、group、version
drop table if exists `t_params_config`;
create table `t_params_config`(
	`key` varchar(32) default '' comment 'key',
	`group` varchar(32) default '' comment '所属组',
	`name` varchar(32) default '' comment '名称',
	`value` varchar(32) default '' comment '值',
	remark varchar(256) default '' comment '备注',
	version bigint default 0 comment '乐观锁',
	primary key(`key`)
)ENGINE=InnoDB default charset=utf8;


#品牌设置
#编号、名称、logo、简介、状态、创建时间
drop table if exists `t_brand`;
create table `t_brand`(
	id bigint not null auto_increment,
	name varchar(32) default '' comment '名称',
	logo varchar(255) default '' comment 'logo',
	`desc` varchar(255) default '' comment '简介',
	status tinyint default 0 comment '状态（0-启用、1-禁用）',
	create_date datetime,
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#仓库设置
#编号、仓库名称、用途、备注、创建时间、所属渠道
drop table if exists `t_store`;
create table `t_store`(
	id bigint not null auto_increment,
	name varchar(32) default '' comment '仓库名称',
	code varchar(16) default '' comment '仓库编号',
	useage varchar(32) default '' comment '用途',
	address varchar(128) default '' comment '地址',
	linkman varchar(32) default '' comment '联系人',
	phone varchar(32) default '' comment '联系电话',
	remark varchar(32) default '' comment '备注',
	type tinyint default 0 comment '类型(1-公司仓库、0-渠道仓库)',
	is_delete tinyint default 0 comment '是否可删(0-可删, 1-不可删)',
	status tinyint default 0 comment '状态（0-启用、1-禁用）',
	create_date datetime,
	channel_id bigint default 0,
	primary key(id)
)ENGINE=InnnoDB default charset=utf8;

#生产单位
#编号、名称、简称、类型、负责人、联系电话、状态
drop table if exists t_workshop;
create table t_workshop(
	id bigint not null auto_increment,
	name varchar(32) default '' comment '名称',
	short_name varchar(16) default '' comment '简称',
	type tinyint default 0 comment '类型（0-内部、1-外发）',
	linkman varchar(32) default '' comment '联系人',
	phone varchar(16) default '' comment '电话',
	status tinyint default 0 comment '状态（0-启用、1-禁用）',
	address varchar(128) default '' comment '地址',
	remark varchar(256) default '' comment '备注',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;


#会员设置
#编号、名称、级别、最小积分、最大积分、规则
drop table if exists `t_set_member`;
create table `t_set_member`(
	id bigint not null auto_increment,
	name varchar(32) default '' comment '名称',
	level tinyint default 1 comment '会员级别（0-普通）',
	min_score int default 0 comment '最小积分',
	max_score int default 0 comment '最大积分',
	divide int default 1 comment '',
	score int default 0 comment '',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#渠道
#编号、名称、类型、父级、经销类别、店铺编号、名称、简称、负责人、电话1、电话2、传真、区域、省份、城市、地址、对账日、电子印章、门店照片
#法人证件、企业证件、提交人、创建时间、审核状态、审核时间、审核人
drop table if exists t_channel;
create table `t_channel`(
	id bigint not null auto_increment,
	name varchar(32) default '' comment '',
	type tinyint default 0 comment '类型(-1-公司、0-代理、1-门店)',
	fid bigint default 0 comment '父ID',
	`level` tinyint default 1 comment '级别',
	category tinyint default 0 comment '经销类别（0-自营、1-第三方）',
	code varchar(32) default '' comment '店铺编号',
	short_name varchar(32) default '' comment '简称',
	linkman varchar(32) default '' comment '联系人',
	phone1 varchar(32) default '' comment '电话1',
	phone2 varchar(32) default '' comment '电话2',
	fax varchar(32) default '' comment '传真',
	area varchar(32) default '' comment '区域',
	province varchar(32) default '' comment '省份',
	city varchar(32) default '' comment '城市',
	address varchar(128) default '' comment '地址',
	check_day int default 0 comment '对账日',
	prefix varchar(16) default '' comment '前缀',
	`desc` varchar(255) default '' comment '简介',
	seal varchar(255) default '' comment '电子印章',
	shop_img varchar(255) default '' comment '门店照片',
	status tinyint default 0 comment '状态(0-启用、1-禁用)',
	leagal_person_licenses varchar(1024) default '' comment '法人证照',
	company_licenses varchar(1024) default '' comment '公司证照',
	create_person bigint comment '创建人',
	create_date datetime comment '创建时间',
	check_status tinyint default 0 comment '0-待审核、1-未通过、2-已通过',
	check_date datetime comment '审核时间',
	check_person bigint comment '审核人',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#渠道购货
#编号、品牌、信用额度、购货达标额、折扣1、折扣2、折扣3、所属渠道
drop table if exists `t_channel_purchase`;
create table `t_channel_purchase`(
	id bigint not null auto_increment,
	brand_id bigint not null comment '品牌ID',
	credit int default 0 comment '信用额度',
	purchase_amount bigint default 0 comment '购货达标额',
	discount1 int default 1 comment '折扣',
	discount2 int default 1 comment '临时折扣',
	discount3 varchar(16) default 'discount1' comment '购货使用折扣',
	channel_id bigint not null comment '所属渠道',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#区域
#编号、名称
drop table if exists `t_area`;
create table `t_area`(
	id bigint not null,
	name varchar(32) default '' comment '区域名称',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#省份
#编号、区域、名称
drop table if exists `t_province`;
create table `t_province`(
	id bigint not null,
	area_id bigint default 0 comment '区域',
	name varchar(32) default '' comment '名称',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#城市
#编号、省份、名称
drop table if exists `t_city`;
create table `t_city`(
	id bigint not null,
	province_id bigint default 0 comment '省份',
	name varchar(32) default '' comment '名称',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#货品类型
#编号、名称
drop table if exists `t_category`;
create table `t_category`(
	id bigint not null auto_increment,
	name varchar(32) default '' comment '名称',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#颜色
#编号、名称
drop table if exists `t_color`;
create table `t_color`(
	id bigint not null auto_increment,
	color varchar(32) default '' comment '',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#尺寸
#编号、名称
drop table if exists `t_size`;
create table `t_size`(
	id bigint not null auto_increment,
	size varchar(32) default '' comment '',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#款号
drop table if exists `t_style`;
create table `t_style`(
	id bigint not null auto_increment,
	style varchar(32) default '' comment '名称',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#系列
drop table if exists `t_series`;
create table `t_series`(
	id bigint not null auto_increment,
	series varchar(32) default '' comment '名称',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#包型
drop table if exists `t_package_type`;
create table `t_package_type`(
	id bigint not null auto_increment,
	package_type varchar(32) default '' comment '名称',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#五金
drop table if exists `t_hardware`;
create table `t_hardware`(
	id bigint not null auto_increment,
	hardware varchar(32) default '' comment '名称',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#面料
drop table if exists `t_material`;
create table `t_material`(
	id bigint not null auto_increment,
	material varchar(32) default '' comment '名称',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#工艺特技
drop table if exists `t_skil`;
create table `t_skil`(
	id bigint not null auto_increment,
	skil varchar(32) default '' comment '名称',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#季节
drop table if exists `t_season`;
create table `t_season`(
	id bigint not null auto_increment,
	season varchar(32) default '' comment '季节',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#功能
drop table if exists `t_function`;
create table `t_function`(
	id bigint not null auto_increment,
	`function` varchar(32) default '' comment '功能',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#货品
#编号、条码、品牌、货品图片、类别、颜色、尺寸、上市时间、吊牌价1、吊牌价2
#创建人、审核状态、价格创建人、价格审核状态、自定义20、自定义10
drop table if exists `t_product`;
create table `t_product`(
	id bigint not null auto_increment,
	code varchar(32) default '' comment '条码',
	brand varchar(32) default '' comment '品牌',
	img varchar(1024) default '' comment '图片',
	type varchar(16) default '' comment '类别',
	color varchar(16) default '' comment '颜色',
	size varchar(16) default '' comment '尺寸',
	year int default 0 comment '年份',
	style varchar(32) default '' comment '款号',
	series varchar(32) default '' comment '系列',
	package_type varchar(16) default '' comment '包型',
	hardware varchar(16) default '' comment '五金',
	material varchar(32) default '' comment '面料',
	skil varchar(32) default '' comment '工艺特技',
	function varchar(32) default '' comment '功能',
	season varchar(32) default '' comment '季节',
	sale_date datetime comment '上市时间',
	dp1 int default 0 comment '吊牌价1',
	dp2 int default 0 comment '吊牌价2',
	purchase_price varchar(32) default 'dp2' comment '购货价',
	enable_discount tinyint default 0 comment '是否计算折扣',
	create_person bigint comment '创建人',
	create_date datetime comment '创建时间',
	check_status tinyint default 0 comment '审核状态（0-未审核、1-不通过、2-通过）',
	price_create_person bigint comment '价格创建人',
	price_check_status tinyint default 0 comment '价格审核状态（0-未录入、1-待审核、2-不通过、3-通过）',
	r1 varchar(32) default '' comment '自定义1',
	r2 varchar(32) default '' comment '自定义2',
	r3 varchar(32) default '' comment '自定义3',
	r4 varchar(32) default '' comment '自定义4',
	r5 varchar(32) default '' comment '自定义5',
	r6 varchar(32) default '' comment '自定义6',
	r7 varchar(32) default '' comment '自定义7',
	r8 varchar(32) default '' comment '自定义8',
	r9 varchar(32) default '' comment '自定义9',
	r10 varchar(32) default '' comment '自定义10',
	r11 varchar(32) default '' comment '自定义11',
	r12 varchar(32) default '' comment '自定义12',
	r13 varchar(32) default '' comment '自定义13',
	r14 varchar(32) default '' comment '自定义14',
	r15 varchar(32) default '' comment '自定义15',
	r16 varchar(32) default '' comment '自定义16',
	r17 varchar(32) default '' comment '自定义17',
	r18 varchar(32) default '' comment '自定义18',
	r19 varchar(32) default '' comment '自定义19',
	r20 varchar(32) default '' comment '自定义20',
	d1 int default 0 comment '价格1',
	d2 int default 0 comment '价格2',
	d3 int default 0 comment '价格3',
	d4 int default 0 comment '价格4',
	d5 int default 0 comment '价格5',
	d6 int default 0 comment '价格6',
	d7 int default 0 comment '价格7',
	d8 int default 0 comment '价格8',
	d9 int default 0 comment '价格9',
	d10 int default 0 comment '价格10',
	status tinyint default 0 comment '状态（0-在产、1-停产）',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#自定义字段对照表
#字段名、名称、是否下拉可选、备注
drop table if exists `t_set_field_define`;
create table `t_set_field_define`(
	field varchar(16) not null,
	name varchar(32) default '' comment '名称',
	is_select tinyint default 0 comment '0-输入、1-可选',
	remark varchar(256) default '' comment '备注',
	primary key(field)
)ENGINE=InnoDB default charset=utf8;

#货品改动记录
#编号、记录时间、备注内容、事件编码
drop table if exists t_product_modify_record;
create table t_product_modify_record(
	id bigint not null auto_increment,
	product_id bigint not null comment '货品ID',
	content varchar(128) default '' comment '备注内容',
	event_code varchar(16) default '' comment '事件编码',
	create_date datetime comment '创建时间',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;



#通讯录
#营业员管理

###############################################################################
######################设置
###############################################################################
#权限管理
#用户
#编号、用户名、密码、昵称、姓名、性别、头像、电话、地址、状态、微信openId、QQId、创建时间、所属组、备注、级别、所属渠道
drop table if exists t_manager;
create table `t_manager`(
	id bigint not null auto_increment,
	username varchar(32) not null default '' comment '用户名',
	password varchar(64) not null default '' comment '密码',
	nickname varchar(32) default '' comment '昵称',
	name varchar(32) default '' comment '名称',
	sex tinyint default 0 comment '0-男，1-女',
	avator varchar(256) default '' comment '头像',
	phone varchar(32) default '' comment '电话',
	email varchar(64) default '' comment '邮箱',
	address varchar(128) default '' comment '地址',
	status tinyint default 0 comment '0-启用，1-禁用',
	wx_open_id varchar(64) default '' comment 'openId',
	qq_open_id varchar(64) default '' comment 'QQ openId',
	create_date datetime comment '创建时间',
	level tinyint default 0 comment '0-本体、1-1级、2-2级、3-3级、4-店铺',
	channel_id bigint default -1 comment '代理ID',
	shop_id bigint default -1 comment '店铺ID',
	`group` bigint not null comment ''所属权限组,
	primary key(id)
)ENGINE=InnoDB default charset=utf8;


#组
#编号、组名、类型、创建时间、状态、备注
drop table if exists `t_group`;
create table `t_group`(
	id bigint not null auto_increment,
	name varchar(32) not null default '' comment '组名',
	type int default 0 comment '类型(0-总部、1-1级、2-2级、3-3级、4-店铺)',
	create_date datetime comment '创建时间',
	status tinyint default 0 comment '状态（0-启用、1-禁用）',
	remark varchar(255) default '' comment '备注',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;


#权限
#编号、父ID、名称、key、图标、地址、type、级别
drop table if exists `t_permission`;
create table `t_permission`(
	id bigint not null,
	fid bigint not null,
	name varchar(32) default '' comment '名称',
	`key` varchar(32) default '' comment '关键词',
	icon varchar(32) default '' comment '图标',
	url varchar(128) default '' comment '地址',
	`type` tinyint default 0 comment '类型(0-菜单、1-权限)',
	level tinyint default 0 comment '(-1-公共,0-总部、1-1级、2-2级、3-3级、4-店铺)',
	menu_level tinyint default 1 comment '菜单级别（1-一级、2-二级、3-三级）',
	redirect varchar(128) default '' comment '重定向-vue',
	component varchar(128) default '' comment '组件地址-vue',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#用户权限
drop table if exists `t_manager_permission`;
create table `t_manager_permission`(
	manager_id bigint not null,
	permission_id bigint not null,
	primary key(manager_id, permission_id)
)ENGINE=InnoDB default charset=utf8;

#组权限
drop table if exists `t_group_permission`;
create table `t_group_permission`(
	group_id bigint not null,
	permission_id bigint not null,
	primary key(group_id, permission_id)
)ENGINE=InnoDB default charset=utf8;

#市场参数设置
#编号、周数、周销量、类型（热销/滞销/平销）、更新时间
drop table if exists t_set_market_sale;
create table `t_set_market_sale`(
	id bigint not null auto_increment,
	week_num int default 0 comment '周数',
	week_sale int default 0 comment '周销量',
	type tinyint default 0 comment '类型（0-热销、1-滞销、2-平销）',
	update_date datetime,
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#市场可调货设置
#编号、周数、周均销、可售周、更新时间
drop table if exists t_set_adjustion;
create table `t_set_adjustion`(
	id bigint not null auto_increment,
	week_num int default 0 comment '周数',
	week_sale int default 0 comment '周销量',
	able_sale_week int default 0 comment '可售周',
	update_date datetime,
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#市场补货/配货设置
drop table if exists t_set_market_sort;
create table `t_set_market_sort`(
	id bigint not null auto_increment,
	type tinyint default 0 comment '类型（0-补货、1-配货）',
	data int default 0 comment '数据',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#流程设置
#编号、模块、流程名称、级别、流程编码（'000','100'）、审核人、是否自动审核、更新时间
drop table if exists t_set_workflow;
create table `t_set_workflow`(
	id bigint not null auto_increment,
	`permission_id` bigint default 0 comment '权限ID',
	name varchar(32) default '' comment '流程名称',
	`level` tinyint default 0 comment '级别(0-本体、1-1级、2-2级、3-3级、4-店铺)',
	channel_id bigint default -1 comment '渠道ID',
	code varchar(8) default 00 comment '流程编码',
	auditor bigint not null comment '审核人',
	status tinyint default 0 comment '是否自动审核（0-手动、1-自动）',
	update_date datetime,
	primary key(id)
)ENGINE=InnoDB default charset=utf8;


#店铺调货单
#调货单号、类型（正常调货、次品退回）、调入方、调出方、备注、创建时间、下单者、状态（0-待提交、1-待审核、1-被驳回、2-已审核待调出、3-已调出待收、4-已完成）
drop table if exists t_shop_out;
create table t_shop_out(
	id varchar(32) not null,
	type tinyint default 0 comment '类型',
	`from` bigint not null comment '调出',
	`to` bigint not null comment '调入',
	remark varchar(256) default '' comment '备注',
	create_date datetime comment '创建时间',
	operator bigint not null comment '创建者',
	status tinyint default 0 comment '状态（0-待提交、1-待审核、1-被驳回、2-已审核待调出、3-已调出待收、4-已完成）',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#调货详情
#编号、调货单号、货品编号、调货量
drop table if exists t_shop_out_detail;
create table t_shop_out_detail(
	id bigint not null auto_increment,
	shop_out_id varchar(32) not null comment '调货单ID',
	product_id bigint not null,
	dp_price int default 0 comment '吊牌价',
	num int default 0 comment '调货量',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;


#退货单
#退货单单号、退货类型、退货原因、退货渠道、收货渠道、备注、配货单号、下单者、下单日期、状态（0-待提交、1-已提交审核、2-被驳回、3-审核通过 、4-已完成、10、11、12、20、21、22、30、31、32）
drop table if exists `t_return`;
create table t_return(
	id varchar(32) not null,
	type tinyint default 0 comment '退货类型(0-正常退货、1-虚拟退货)',
	reason tinyint default 0 comment '退货原因(0-质量问题、1-滞销、2-扫描识别问题、3-市场调货、4-其它)',
	`from` bigint not null comment '退货渠道',
	`to` bigint not null comment '收货渠道',
	remark varchar(256) default '' comment '备注',
	sorting_id varchar(32) default '' comment '',
	operator bigint not null comment '下单者',
	create_date datetime comment '下单日期',
	status tinyint default 0 comment '状态',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#退货详情
#编号、退货单号、货品编号、吊牌价、退货价、数量
drop table if exists t_return_detail;
create table t_return_detail(
	id bigint not null auto_increment,
	return_id varchar(32) default '' comment '退货单ID',
	product_id bigint not null comment '货品ID',
	dp_price int default 0 comment '吊牌价',
	return_price int default 0 comment '退货价',
	num int default 0 comment '数量',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;


#采购单
#采购单号、计划单号、下单者、下单渠道、下单时间
#、状态（0-待提交、1-已提交待审核、2-被驳回、3-审核通过、4-改动待市场确认、5-市场已确认、6-未配完、7-已配完、10、11、12）
drop table if exists t_purchase;
create table `t_purchase`(
	id varchar(32) not null,
	plan_id varchar(32) default '' comment '计划单号',
	operator bigint not null comment '下单者',
	channel_id bigint not null comment '渠道编号',
	create_date datetime not null comment '下单时间',
	status tinyint default 0 comment '状态',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;


#采购单详情
#编号、采购单号、货品编号、吊牌价、采购数量、计划货期、原采购数量、原计划货期
drop table if exists t_purchase_detail;
create table t_purchase_detail(
	id bigint not null auto_increment,
	purchase_id varchar(32) default '' comment '采购单编号',
	product_id bigint not null comment '货品编号',
	dp_price int default 0 comment '吊牌价',
	num int default 0 comment '数量',
	plan_date datetime comment '计划货期',
	old_num int default 0 comment '原采购量',
	old_plan_date datetime comment '原计划货期',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#单据审核记录
#编号、单号、创建人、内容、创建时间、类型（0-采购单审核、1-配货单审核、2-退货单审核、3-入库单状态审核）
drop table if exists t_check_record;
create table t_check_record(
	id bigint not null auto_increment,
	order_no varchar(32) default '' comment '单号',
	operator bigint not null comment '创建人',
	content varchar(32) default '' comment '内容',
	create_date datetime comment '创建时间',
	type tinyint default 0 comment '类型（0-采购单审核、1-配货单审核、2-退货单审核、3-入库单审核）',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;


#计划单
#计划单号、创建时间、创建者、渠道ID、类型（0-一级渠道、1-总部）、最后导出时间
#、状态（0-未提交市场确认、1-提交到市场确认、2-市场已确认、3-本体已确认、4-来货完成、5-配货完成）
drop table if exists t_plan;
create table t_plan(
	id varchar(32) not null,
	create_date datetime comment '创建时间',
	operator bigint not null comment '创建人',
	channel_id bigint not null comment '渠道编号',
	type tinyint default 0 comment '类型(0-一级代理、渠道)',
	status tinyint default 0 comment '状态',
	export_date datetime comment '导出时间',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#计划生产
#编号、计划单号、货品、库存配货数、需生产数、计划货期、创建时间
drop table if exists t_plan_produce;
create table t_plan_produce(
	id bigint not null auto_increment,
	plan_id varchar(32) default '' comment '计划单号ID',
	product_id bigint not null comment '产品编号',
	num int default 0 comment '生产数',
	plan_date datetime comment '计划时间',
	create_date datetime comment '创建时间',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#配货单
#编号、计划单号、采购单号、类型（0-市场调配、1-本地配货）、调入方、调出方、创建时间、创建者、状态（0-待提交调出方确认、1-待调出方确认、2-需修改、3- 待确认、4-已确认（未完成）、5-已发待收货、6-已完成、7-已终止
#、14-已确认（一级代理确认）、24-已确认、34-已确认）
drop table if exists t_sorting;
create table t_sorting(
	id varchar(32) not null,
	plan_id varchar(32) not null comment '计划单ID',
	purchase_id varchar(32) not null comment '采购单ID',
	type tinyint default 0 comment '类型（0-市场调配、1-本地配货）',
	`from` bigint not null comment '调出方',
	`to` bigint not null comment '调入方',
	create_date datetime not null comment '创建时间',
	operator bigint not null comment '创建者',
	status tinyint default 0 comment '状态',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#配货单详情
#编号、配货单编号、货品编号、配货数量
drop table if exists t_sorting_detail;
create table t_sorting_detail(
	id bigint not null auto_increment,
	sorting_id varchar(32) not null comment '配货单ID',
	product_id bigint not null comment '货品编号',
	num int default 0 comment '采购数量',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#配货单记录
#编号、配货单、内容、创建时间
drop table if exists t_sorting_record;
create table t_`sorting_record(
	id bigint not null auto_increment,
	sorting_id varchar(32) not null comment '配货单',
	content varchar(256) default '' comment '内容',
	create_date datetime comment '创建时间',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#生产入库单
#入库单号、下单者、下单时间、生产单位、状态（0-未提交、1-待录入、2-录入识别码驳回、3-录入识别码确认、4-入库驳回、5-入库确认）
drop table t_produce_receipt
create table t_produce_receipt(
	id varchar(32) not null,
	operator bigint not null comment '下单者',
	create_date datetime comment '创建时间',
	workshop_id bigint not null comment '生产单位',
	status tinyint default 0 comment '状态',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#生产入库详情
#编号、入库单编号、计划生产编号、货品、本次来货数量
drop table if exists t_produce_receipt_detail;
create table t_produce_receipt_detail(
	id bigint not null,
	produce_receipt_id varchar(32) not null comment '生产入库单ID',
	plan_produce_id bigint not null comment '计划生产Id',
	product_id bigint not null comment '产品ID',
	num int default 0 comment '产品数量',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#生产入库详情记录
#编号、入库单编号、产品编号、RFID
drop table if exists t_produce_receipt_record;
create table t_produce_receipt_record(
	id bigint not null,
	produce_receipt_id varchar(32) not null comment '入库单编号',
	product_id bigint not null comment '产品ID',
	rfid varchar(32) default '' comment 'RFID',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#店铺入库单
#单号、类型（0-本地调货、1-销售退货）、调出方、调入方、下单者、下单日期、状态（0-待入库、1已完成）、备注单号、备注
drop table if exists t_shop_put
create table `t_shop_put`(
	id varchar(32) not null,
	type tinyint default 0 comment '类型（0-本地调货、1-销售退货）',
	`from` bigint not null comment '调出方',
	`to` bigint not null comment '调入方',
	creator bigint not null comment '创建者',
	create_date datetime not null comment '下单时间',
	sttaus tinyint default 0 comment '状态(0-待入库、1-已完成)',
	remark varchar(256) default '' comment '备注',
	remark_no varchar(32) default '' comment '备注单号',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#店铺入库详情
#编号、入库单号、货品编号、货品数量
drop table if exists t_shop_put_detail;
create table `t_shop_put_detail`(
	id bigint not null,
	shop_put_id varchar(32) not null comment '入库单号',
	product_id bigint not null comment '货品编号',
	num int default 0 comment '货品数量',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#店铺入库RFID记录
#编号、入库详情编号、货品RFID、已扫描（0-未扫描、1-已扫描）
drop table if exists t_shop_put_record;
create table `t_shop_put_record`(
	id bigint not null,
	detail_id bigint not null comment '入库详情ID',
	rfid varchar(32) default '' comment 'RFID',
	is_scan tinyint default 0 comment '是否已扫描',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#店铺出库单
#单号、类型（0-本地调货、1-退货、2-销售出库）、调入方、调出方、下单者、下单日期、状态（0-待扫描出库、1-驳回、2-已完成）、备注单号、备注
drop table if exists t_shop_output;
create table `t_shop_output`(
	id varchar(32) not null,
	type tinyint default 0 comment '类型（0-本地调货、1-退货、2-销售出库）',
	`from` bigint not null comment '调出方',
	`to` bigint not null comment '调入方',
	creator bigint not null comment '创建者',
	create_date datetime not null comment '创建时间',
	status tinyint default 0 comment '状态（0-待扫描出库、1-驳回、2-已完成）',
	remark varchar(256) default '' comment '备注',
	remark_no varchar(32) default '' comment '备注单号',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#店铺出库详情
#编号、出库单号、货品编号、货品数量
drop table if exists t_shop_output_detail;
create table `t_shop_output_detail`(
	id bigint not null,
	shop_output_id varchar(32) not null comment '出库单号',
	product_id bigint not null comment '产品ID',
	num int default 0 comment '产品数量',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#店铺出库RFID记录
#编号、出库详情编号、货品RFID、已扫描（0-未扫描、1-已扫描）
drop table if exists t_shop_output_record;
create table `t_shop_output_record`(
	id bigint not null,
	detail_id bigint not null comment '出库详情ID',
	rfid varchar(32) default '' comment 'RFID',
	is_scan tinyint default 0 comment '是否扫描（0-未扫描、1已扫描）',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#产品库存
#编号、渠道编号、仓库编号、货品编号、货品数量
drop table if exists `t_stock`;
create table `t_stock`(
	id bigint not null auto_increment,
	channel_id bigint not null comment '渠道编号',
	store_id bigint not null comment '仓库编号',
	product_id bigint not null comment '货品ID',
	num int default 0 comment '货品数量',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#库存记录
#编号、库存编号、RFID
drop table if exists `t_stock_record`;
create table `t_stock_record`(
	id bigint not null,
	stock_id bigint not null comment '库存ID',
	rfid varchar(32) default '' comment 'RFID',
	mark tinyint default 0 comment '质检标记（0-无、1-人为损坏、2-质量问题）',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#产品库存使用情况----
#编号、产品库存编号、可配占用数、可配在产数


#入库单
#单号、类型（0-本地调货、1-供应配货、2-虚拟调货、3-虚拟退货、4-虚拟配货、5-退货）
#、数量、调出方、调入方、下单者、下单日期、备注单号（调货单号/采购单号/配货单号/退货单号）、备注、状态（0-待入库、1-已完成）
#完成时间
drop table if exists t_receipt;
create table t_receipt(
	id varchar(32) not null,
	type tinyint default 0 comment '类型(0-本地调货、1-供应配货、2-虚拟调货、3-虚拟退货、4-虚拟配货、5-退货)',
	num int default 0 comment '数量',
	`from` bigint not null comment '调出方',
	`to` bigint not null comment '调入方',
	creator bigint not null comment '创建者',
	create_date datetime comment '创建时间',
	remark_no varchar(32) default '' comment '备注单号',
	remark varchar(256) default '' comment '备注',
	status tinyint default 0 comment '状态(0-待入库、1-已完成)',
	complete_date datetime comment '完成时间',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#入库单详情
#编号、入库单号、产品ID、数量、吊牌价、结算价
drop table if exists t_receipt_detail;
create table t_receipt_detail(
	id bigint not null auto_increment,
	receipt_id varchar(32) default '' comment '入库单编号',
	product_id bigint not null comment '产品ID',
	num int default 0 comment '数量',
	dp_price default 0 comment '吊牌价',
	sale_price default 0 comment '结算价',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#入库单记录
#编号、入库详情编号、货品RFID、已扫描（0-未扫描、1-已扫描）
drop table if exists t_receipt_record;
create table t_receipt_record(
	id bigint not null auto_increment,
	detail_id bigint not null comment '详情ID',
	rfid varchar(32) default '' comment 'RFID',
	id_scan tinyint default 0 comment '已扫描（0-未扫描、1-已扫描）',
	mark tinyint default 0 comment '标记（0-无、1-人为损坏、2-质量问题）',
	`desc` varchar(256) default '' comment '描述',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#出库单
#单号、类型（0-本地调货、1-退货、2-虚拟退货、3-虚拟配货、5-配货出库）、数量、调入方、调出方、下单者、下单时间、备注单号（调货单号/退货单号/配货单号）、备注
#、状态（0-待审核、1-审核不通过、2-审核通过、3-待扫描出库、4-已完成、5-已终止）、完成时间
drop table if exists t_delivery;
create table t_delivery(
	id varchar(32) not null,
	type tinyint default 0 comment '类型（0-本地调货、1-退货、2-虚拟退货、3-虚拟配货）',
	num int default 0 comment '数量',
	`from` bigint not null comment '调出方',
	`to` bigint not null comment '调入方',
	creator bigint not null comment '下单者',
	create_date datetime comment '下单时间',
	remark_no varchar(32) default '' comment '备注单号',
	remark varchar(256) default '' comment '备注',
	status tinyint default 0 comment '状态（0-待扫描出库、1-已完成）',
	complete_date datetime comment '完成时间',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#出库单详情
#编号、出库单号、产品ID、数量、吊牌价、结算价
drop table if exists t_delivery_detail;
create table t_delivery_detail(
	id bigint not null auto_increment,
	delivery_id varchar(32) not null comment '出库单号',
	product_id bigint not null comment '产品ID',
	num int default 0 comment '数量',
	dp_price int default 0 comment '吊牌价',
	price int default 0 comment '结算价',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#出库单记录
#编号、出库单详情编号、货品RFID、已扫描（0-未扫描、1-已扫描）
drop table if exists t_delivery_record;
create table t_delivery_record(
	id bigint not null auto_increment,
	detail_id bigint not null comment '详情ID',
	rfid varchar(32) default '' comment 'RFID',
	is_scan tinyint default 0 comment '已扫描（0-未扫描、1-已扫描）',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#转仓单
#单号、数量、调出仓库、调入仓库、下单者、下单日期、完成日期、状态（0-待确认、1-已完成）
drop table if exists t_transfer;
create table t_transfer(
	id varchar(32) not null,
	num int default 0 comment '数量',
	`from` bigint not null comment '调出仓库',
	`to` bigint not null comment '调入仓库',
	creator bigint not null comment '下单者',
	create_date datetime comment '创建时间',
	status tinyint default 0 comment '状态（0-待确认、1-已完成）',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#转仓单详情
#编号、转仓单号、货品ID、货品RFID、标记、详细描述
drop table if exists t_transfer_detail(
	id bigint not null auto_increment,
	transfer_id varchar(32) not null comment '转仓单号',
	product_id bigint not null comment '产品ID',
	rfid varchar(32) default '' comment '产品RFID',
	mark tinyint default 0 comment '标记（0-无、1-人为损坏、2-质量问题）',
	`desc` varchar(256) default '' comment '描述',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#装箱单
#编号、出库单号、装箱时间
drop table if exists t_packing;
create table t_packing(
	id varchar(32) not null,
	delivery_id varchar(32) not null comment '出库单号',
	create_date datetime comment '装箱时间',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#装箱单详情
#编号、装箱单编号、货号、数量
drop table if exists t_packing_detail;
create table t_packing_detail(
	id bigint not null auto_increment,
	packing_id varchar(32) not null comment '装箱单ID',
	product_id bigint not null comment '产品ID',
	num int default 0 comment '数量',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#装箱单详情记录
#编号、装箱单详情编号、RFID
drop table if exists t_packing_record;
create table t_packing_record(
	id bigint not null auto_increment,
	detail_id bigint not null,
	rfid varchar(32) default '' comment 'RFID',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#盘点单
#单号、仓库、下单者、下单时间、类型（0-核对、1-新增）、数量、新增数、状态（0-盘点中、1-已完成）、备注、完成日期
drop table if exists t_check;
create table t_check(
	id varchar(32) not null,
	store_id bigint not null comment '仓库编号',
	creator bigint not null comment '创建者',
	create_date datetime comment '创建时间',
	type tinyint default 0 comment '类型',
	num int default 0 comment '数量',
	add_num int default 0 comment '新增数',
	status tinyint default 0 comment '状态',
	remark varchar(256) default '' comment '备注',
	complete_date datetime comment '完成日期',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#盘点记录
#编号、盘点单号、货品ID、货品RFID、是否已扫描、是否异常
drop table if exists t_check_detail;
create table t_check_detail(
	id bigint not null,
	check_id varchar(32) not null comment '盘点单ID',
	product_id bigint not null comment '产品ID',
	rfid varchar(32) default '' comment 'RFID',
	is_scan tinyint default 0 comment '是否扫描（0-未扫描、1-已扫描）',
	is_exception tinyint default 0 comment '是否异常（0-正常、1-异常）'
)ENGINE=InnoDB default charset=utf8;


#销售单
#销售单号、渠道ID、顾客姓名、开单人、销售时间、状态（0-待付款、1-已完成）、备注
drop table if exists `t_sale`;
create table `t_sale`(
	id varchar(32) not null,
	channel_id bigint not null comment '渠道编号',
	customer_id bigint not null comment '顾客',
	operator bigint not null comment '开单人',
	sale_date datetime comment '销售时间',
	status tinyint default 0 comment '状态（0-待付款，1-已完成）',
	remark varchar(256) default '' comment '备注',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#销售单详情
#编号、销售单号、货品条码、吊牌价、单价、数量、折扣、类型（0-销售、1-退货）
drop table if exists `t_sale_detail`;
create table `t_sale_detail`(
	id bigint not null auto_increment,
	sale_id varchar(32) default '' comment '销售单号',
	product_id bigint comment '货品ID',
	dp_price int default 0 comment '吊牌价',
	unit_price int default 0 comment '单价',
	num int default 0 comment '数量',
	discount int default 0 comment '折扣',
	type tinyint default 0 comment '类型（0-销售、1-退货）',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;

#销售详情记录
#编号、销售单详情编号、RFID       包含记录RFID
drop table if exists `t_sale_detail_record`;
create table `t_sale_detail_record`(
	id bigint not null auto_increment,
	sale_detail_id bigint not null comment '销售详情ID',
	rfid varchar(32) default '' comment 'RFID',
	primary key(id)
)ENGINE=InnoDB default charset=utf8;


-- -----------------------------------------------------
-- Table `test`.`clientdetails`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clientdetails`;
CREATE TABLE `clientdetails` (
  `appId` VARCHAR(128) NOT NULL,
  `resourceIds` VARCHAR(256) NULL DEFAULT NULL,
  `appSecret` VARCHAR(256) NULL DEFAULT NULL,
  `scope` VARCHAR(256) NULL DEFAULT NULL,
  `grantTypes` VARCHAR(256) NULL DEFAULT NULL,
  `redirectUrl` VARCHAR(256) NULL DEFAULT NULL,
  `authorities` VARCHAR(256) NULL DEFAULT NULL,
  `access_token_validity` INT(11) NULL DEFAULT NULL,
  `refresh_token_validity` INT(11) NULL DEFAULT NULL,
  `additionalInformation` VARCHAR(4096) NULL DEFAULT NULL,
  `autoApproveScopes` VARCHAR(256) NULL DEFAULT NULL,
  PRIMARY KEY (`appId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `oatuh2`.`oauth_access_token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` VARCHAR(256) NULL DEFAULT NULL,
  `token` BLOB NULL DEFAULT NULL,
  `authentication_id` VARCHAR(128) NOT NULL,
  `user_name` VARCHAR(256) NULL DEFAULT NULL,
  `client_id` VARCHAR(256) NULL DEFAULT NULL,
  `authentication` BLOB NULL DEFAULT NULL,
  `refresh_token` VARCHAR(256) NULL DEFAULT NULL,
  PRIMARY KEY (`authentication_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `oatuh2`.`oauth_approvals`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
  `userId` VARCHAR(256) NULL DEFAULT NULL,
  `clientId` VARCHAR(256) NULL DEFAULT NULL,
  `scope` VARCHAR(256) NULL DEFAULT NULL,
  `status` VARCHAR(10) NULL DEFAULT NULL,
  `expiresAt` DATETIME NULL DEFAULT NULL,
  `lastModifiedAt` DATETIME NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `oatuh2`.`oauth_client_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` VARCHAR(128) NOT NULL,
  `resource_ids` VARCHAR(256) NULL DEFAULT NULL,
  `client_secret` VARCHAR(256) NULL DEFAULT NULL,
  `scope` VARCHAR(256) NULL DEFAULT NULL,
  `authorized_grant_types` VARCHAR(256) NULL DEFAULT NULL,
  `web_server_redirect_uri` VARCHAR(256) NULL DEFAULT NULL,
  `authorities` VARCHAR(256) NULL DEFAULT NULL,
  `access_token_validity` INT(11) NULL DEFAULT NULL,
  `refresh_token_validity` INT(11) NULL DEFAULT NULL,
  `additional_information` VARCHAR(4096) NULL DEFAULT NULL,
  `autoapprove` VARCHAR(256) NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `oatuh2`.`oauth_client_token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
  `token_id` VARCHAR(256) NULL DEFAULT NULL,
  `token` BLOB NULL DEFAULT NULL,
  `authentication_id` VARCHAR(128) NOT NULL,
  `user_name` VARCHAR(256) NULL DEFAULT NULL,
  `client_id` VARCHAR(256) NULL DEFAULT NULL,
  PRIMARY KEY (`authentication_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `oatuh2`.`oauth_code`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code` VARCHAR(256) NULL DEFAULT NULL,
  `authentication` BLOB NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `oatuh2`.`oauth_refresh_token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` VARCHAR(256) NULL DEFAULT NULL,
  `token` BLOB NULL DEFAULT NULL,
  `authentication` BLOB NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
