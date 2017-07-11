--
-- 监测设备发放表
--
-- v1.0 2017.01.19
-- author：alex
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_dev_issue_hmo;
create table  fxp.p_dev_issue_hmo (
-- +-----------------------------+--------------+-----------+
   fissue_id                     varchar2(32)   not null,   -- 发放ID
   --
   -- 用户
   --
   fperson_id                    varchar2(32)   not null,   -- 客户ID
   fperson_name                  varchar2(50)   not null,   -- 客户姓名
   --
   -- 设备详情
   --
   fdevice_id                    varchar2(32)   not null,   -- 设备id
   fcompany_id                   varchar2(32)   not null,   -- 设备厂商_id
   fcompany_name                 varchar2(30)   not null,   -- 设备厂商_name
   fdevice_model_id              varchar2(32)   not null,   -- 设备型号ID
   fdevice_model_name            varchar2(50)   not null,   -- 设备型号名称
   fmax_user                     number(3,0)    not null,   -- 设备最大用户数，默认为1
   fdevice_sn                    varchar2(32)   not null,   -- 设备序列号
   fdevice_uuid                  varchar2(32),              -- 设备内部ID
   fproduction_date              date,                      -- 生产日期
   fpurchase_date                date,                      -- 购买日期
   fuser_no                      number(3,0)    not null,   -- 用户编号
   fdevice_Desc                  varchar2(256),             -- 备注
   --
   -- APP用户名及密码
   --
   fapp_username                 varchar2(50),              -- APP的登录用户名
   fapp_password                 varchar2(50),              -- APP的登录用户密码
   --
   -- 所属工作圈
   --
   fcircle_id                   varchar2(32),              -- 工作圈id      
   --
   -- 发放
   --
   fissue_date                   date           not null,   -- 发放时间
   fissue_circle_id              varchar2(32)   not null,   -- 发放工作圈id
   fissue_team_id                varchar2(32)   not null,   -- 发放工作组id
   fissue_team_name              varchar2(100)  not null,   -- 发放工作组名称     
   fissue_user_id                varchar2(32)   not null,   -- 发放操作员id
   fissue_nickname               varchar2(40)   not null,   -- 发放操作员姓名
   fissue_desc                   varchar2(256),             -- 发放备注 
-- +-----------------------------+--------------+-----------+
   --
   -- 日志
   --
   fversion                      number(6)                  -- 版本号
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
   constraint pk_p_dev_issue_hmo primary key (fissue_id),
   constraint uk_p_dev_issue_hmo_device unique (fdevice_id,fuser_no),
   constraint uk_p_dev_issue_hmo_sn unique (fdevice_sn,fcompany_id,fdevice_model_id,fuser_no)
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


--
-- 修改历史：
--
