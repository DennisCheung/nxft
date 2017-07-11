--
-- 配餐对象表
--
-- v1.0 2017.05.01
-- author：wing
--
-- 修改历史：
-- 
--
--
-- Drop Table nxft.nxft_subject;
Create Table  nxft.nxft_subject (
-- +-----------------------------+--------------+-----------+
   fsubject_id                   varchar2(32)   not null,   -- 对象id
   --
   -- 对象基础信息
   --
   fperson_id                    varchar2(32)   not null,   -- 客户ID
   fsubject_name                 varchar2(80)   not null,   -- 姓名
   fsex_id                       varchar2(32)   not null,   -- 性别id     fxp.p_sex 字典
   fsex_name                     varchar2(30)   not null,   -- 性别name
   fidtype_id                    varchar2(32)   not null,   -- 证件类别id
   fidtype_name                  varchar2(30)   not null,   -- 证件类别中文
   fidcardno                     varchar2(20)   not null,   -- 身份证号
   fbirth_date                   date           not null,   -- 出生日期
   fcontact_phone                varchar2(30),              -- 联系电话
   fregion_id                    varchar2(32)   not null,   -- 行政区域ID
   fregion_name                  varchar2(80)   not null,   -- 行政区域名称
   faddress                      varchar2(200)  not null,   -- 详细地址
   fis_native                    char(1),                   -- 是否本地户籍（本镇）Y/N
   fliving_condi_name            varchar2(60),              -- 居住情况，多选，用逗号分隔
   --
   -- 客户所属
   --
   fcircle_id                    varchar2(32)   not null,   -- 客户所属的工作圈id   
   --
   -- 对象扩展信息
   --
   frelation_name                varchar2(40),              -- 联系人姓名
   ffamily_relation_id           varchar2(32),              -- 联系人关系ID
   ffamily_relation_name         varchar2(30),              -- 联系人关系name   
   frelation_phone               varchar2(40),              -- 联系人电话
   fis_gov_help                  char(1) default 'N'    not null, -- 是否属于政府扶助类型
   fgov_help_id                  varchar2(32),              -- 政府扶助类型id
   fgov_help_name                varchar2(30),              -- 政府扶助类型中文名称
   fsubject_disease              varchar2(100),             -- 对象所患疾病，名称逗号分隔
   fhave_food_allergy            char(1) default 'N'    not null, -- 是否有食物过敏
   ffood_allergy                 varchar2(200),             -- 食物过敏
   fsubject_food_prohibit        varchar2(100),             -- 对象食物禁忌，名称逗号分隔
   fsubject_food_love_id         varchar2(32),              -- 对象饮食偏好id
   fsubject_food_love_name       varchar2(30),              -- 对象饮食偏好name
   fis_meal_help                 char(1) default 'N'    not null, -- 进餐是否协助
   fsubject_type_id              varchar2(32)   not null,   -- 对象类型id
   fsubject_type_name            varchar2(30)   not null,   -- 对象类型中文名称
   flunch_box_no                 varchar2(20),              -- 饭盒编号
   fsubject_desc                 varchar2(256),             -- 对象备注
   --
   -- 配餐信息
   --
   fdelive_type                  varchar2(30)   not null,   -- 配送方式  助餐点 SITE  到户  HOME
   fdelive_site_id               varchar2(32)   not null,   -- 配送地点id
   fdelive_site_name             varchar2(40)   not null,   -- 配送地点名称
   foverdraft                    number(8,2)    not null,   -- 配餐透支额度
   --
   -- 创建者信息
   --
   fcreate_time                  date           not null,   -- 创建时间
   fcreate_circle_id             varchar2(32)   not null,   -- 创建工作圈id
   fcreate_team_id               varchar2(32)   not null,   -- 创建工作组id
   fcreate_user_id               varchar2(32)   not null,   -- 创建工号id
   fcreate_nickname              varchar2(30)   not null,   -- 创建姓名
   --
   -- 注销
   --
   fis_cancel                    char(1) default 'N'  not null, -- 是否被注销
   fcancel_reason                varchar2(60),              -- 注销原因
   fcancel_date                  date,                      -- 注销机器时间
   fcancel_user_id               varchar2(32),              -- 注销操作员id   
   fcancel_user_name             varchar2(30),              -- 注销操作员姓名
-- +-----------------------------+--------------+-----------+
   --
   -- 日志
   --
   fversion                      number(6)                   -- 版本号
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- 创建者
   flogcdate                     date           not null,   -- 创建时间
   flogluby                      varchar2(32)   not null,   -- 最后修改者
   flogludate                    date           not null,   -- 最后修改时间
   floglaby                      varchar2(32)   not null,   -- 最后访问者
   flogladate                    date           not null,   -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_nxft_subject primary key (fsubject_id)
   --
   -- 约束
   --
);

--
-- 索引
--


--
-- 修改语句
--
