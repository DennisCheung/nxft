--
-- 客户档案表
--
-- v1.0 2014.12.08
-- author：wing
--
-- 修改历史：
-- V1.1 2015.05.19 del by wing   fmanageunit_name    管理机构id，取消管理机构
-- V1.2 2015.06.02 del by wing   fpassword    用户密码，移到p_user表 
-- V1.2 2015.06.02 add by wing   fuser_id    用户密码，绑定用户id 
-- V1.3 2015.06.25 add by wing   将健康档案 籍贯、联系人姓名、联系电话 移到person表
-- V1.4 2015.07.29 del by wing   删除user_id 用户和客户为绑定关系
-- V1.5 2016.09.10 add by wing   增加运营商id  foperator_id
-- V1.6 2016.10.10 add by wing   将该表命名为客户档案表，移到fxp下
--
--   
-- drop table fxp.p_person;
create table  fxp.p_person (
-- +-----------------------------+--------------+-----------+
   fperson_id                    varchar2(32)   not null,   -- 居民ID， 
   fperson_code                  varchar2(32)   not null,   -- 居民编号，居民建档时的编号。
   fuser_id                      varchar2(32),              -- 用户id
   --
   -- 个人基本信息
   -- 
   fperson_name                  varchar2(50)   not null,   --  居民姓名
   fidtype_id                    varchar2(32),              --  证件类别id ->p_id_typ
   fidtype_name                  varchar2(30),              --  证件类别中文     微信默认二代身份证
   fid_no                        varchar2(30),              --  证件编号（身份证）
   fsex_id                       varchar2(32),              --  性别id    1男 2女 3未知
   fsex_name                     varchar2(30),              --  性别中文
   fbirth_date                   date,                      --  出生日期, 年龄通过出生日期计算出来。
   --
   -- 家庭
   -- 
   ffamily_id                    varchar2(32)   not null,   --  家庭id
   fhouse_relation_id            varchar2(32)   not null,   --  与户主关系ID
   fhouse_relation_name          varchar2(30)   not null,   --  与户主关系中文   
   --
   -- 扩展信息
   --
   fis_native                    char(1),                   -- 是否本地户籍（本市）Y/N
   fregister_addr                varchar2(50),              -- 户籍地址
   fnation_id                    varchar2(32),              -- 民族id（->公共字典表）, 默认汉族
   fnation_name                  varchar2(30),              -- 民族中文
   fmarriage_id                  varchar2(32),              -- 婚姻状况id（->公共字典表）
   fmarriage_name                varchar2(30),              -- 婚姻状况中文
   fedu_degree_id                varchar2(32),              -- 文化程度id（->公共字典表）
   fedu_degree_name              varchar2(30),              -- 文化程度中文
   foccupation_id                varchar2(32),              -- 职业id（->公共字典表）
   foccupation_name              varchar2(30),              -- 职业中文  
   flanguage_name                varchar2(30),              -- 多选，日常沟通语言中文，用逗号分隔
   fphoto_id                     varchar2(32),              -- 照片id
   feconomy_state_id             varchar2(32),              -- 经济状况id
   feconomy_state_name           varchar2(30),              -- 经济状况中文
   --
   -- 联系信息
   --
   -- fperson_email              varchar2(30),              --  居民本人邮箱
   fperson_mobile                varchar2(30),              --  居民手机
   fworkunit_name                varchar2(50),              --  工作单位名称
   -- fcontact_name              varchar2(50),              --  [V1.3] 联系人姓名
   -- fcontact_phone             varchar2(30),              --  [V1.3] 联系电话   
   -- 
   -- 医疗待遇
   --
   fmedinsu_meth_id               varchar2(32),             -- 医疗保险方式id
   fmedinsu_meth_name             varchar2(30),             -- 医疗保险方式  名称
   --
   -- 健康状况
   --
   fhealth_state_id               varchar2(32),             -- 健康状况id
   fhealth_state_name             varchar2(30),             -- 健康状况中文
   fperson_disease                varchar2(50),             -- 所患疾病，名称逗号分隔
   fperson_desc                   varchar2(256),            -- 个人备注     
   --
   -- 福来服务
   --
   fcustomer_type_id              varchar2(32),             -- 客户类型id
   fcustomer_type_name            varchar2(30),             -- 客户类型中文名称
   --
   -- 所属工作圈
   --   
   fcircle_id                     varchar2(32)   not null,   -- 工作圈id
   flast_service_date             date default sysdate not null,  -- 最后服务日期
   --
   -- 开通
   --
   fregist_way                    varchar2(20)   not null,   -- *注册方式   SELF  自助  CM  社区  SEAT 坐席
   fcreate_date                   date default sysdate not null, -- 注册日期（录入时输入的日期） 
   fcreate_user_id                varchar2(32),              -- 注册操作员id
   fcreate_user_name              varchar2(30),              -- 注册操作员姓名
   --
   -- 注销
   --
   fis_cancel                    char(1) default 'N'  not null, -- 是否被注销
   -- 注销类型
   fcancel_reason                varchar2(60),              -- 注销原因
   fcancel_date                  date,                      -- 注销机器时间
   fcancel_user_id               varchar2(32),              -- 注销操作员id   
   fcancel_user_name             varchar2(30),              -- 注销操作员姓名   
-- +-----------------------------+--------------+-----------+
   --
   -- 日志
   --
   fversion                      number(6)                  -- 版本号
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- 创建者
   flogcdate                     date default sysdate not null,   -- 创建时间
   flogluby                      varchar2(32)   not null,   -- 最后修改者
   flogludate                    date default sysdate not null,   -- 最后修改时间
   floglaby                      varchar2(32)   not null,   -- 最后访问者
   flogladate                    date default sysdate not null,   -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_p_person primary key (fperson_id),
   constraint uk_p_person_code unique (fperson_code),
-- constraint uk_p_person_user unique (fuser_id),
   constraint uk_p_person_idno unique (fid_no),
   constraint uk_p_person_mobile unique (fperson_mobile)
   --
   -- 约束
   --
);

--
-- 同义词
--

--
-- 授权
--

--
-- 索引
--
 create index fxp.idx_p_person_name on fxp.p_person(fperson_name);
-- create index fxp.idx_p_person_mobile on fxp.p_person(fperson_mobile);
 create index fxp.idx_p_person_create_date on fxp.p_person(fcreate_date); 
--
-- 修改语句
--

