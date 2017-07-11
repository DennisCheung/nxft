--
-- 手环入库表
--
-- v1.0 2016.10.08
-- author：wing
--
--
-- 修改历史：
--
--
--
-- drop table fxp.p_device_wristband;
create table  fxp.p_device_wristband (
-- +-----------------------------+--------------+-----------+
   fdevice_id                    varchar2(32)   not null,   -- 设备id
   fcompany_id                   varchar2(32)   not null,   -- 设备厂商_id
   fcompany_name                 varchar2(30)   not null,   -- 设备厂商_name
   fdevice_model_id              varchar2(32)   not null,   -- 设备型号ID
   fdevice_model_name            varchar2(50)   not null,   -- 设备型号名称
   fdevice_sn                    varchar2(32)   not null,   -- 设备序列号
   fdevice_uuid                  varchar2(32),              -- 设备内部ID
   fproduction_date              date,                      -- 生产日期
   fpurchase_date                date,                      -- 购买日期
   fdevice_desc                  varchar2(256),             -- 备注
   --
   -- 所属运营商
   --
   fcircle_id                    varchar2(32),              -- 工作圈id   
   --
   -- 创建者
   --
   fcreate_date                  date           not null,   -- 创建时间
   fcreate_circle_id             varchar2(32)   not null,   -- 创建工作圈id
   fcreate_team_id               varchar2(32)   not null,   -- 创建工作组id
   fcreate_team_name             varchar2(100)  not null,   -- 创建工作组名称
   fcreate_user_id               varchar2(32)   not null,   -- 创建操作员id
   fcreate_nickname              varchar2(40)   not null,   -- 创建操作员姓名
   --
   -- 使用
   --
   fis_used                      char(1) default 'N'  not null, -- 是否被使用
   fused_type                    varchar2(30),              -- 使用类型  ISSUE 发放  CANCEL 作废
   fused_date                    date,                      -- 使用时间
   fused_user_id                 varchar2(32),              -- 使用操作员id
   fused_nickname                varchar2(40),              -- 使用操作员姓名
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
   constraint pk_p_device_wristband primary key (fdevice_id),
   constraint uk_p_device_wristband unique (fdevice_sn,fcompany_id,fdevice_model_id)
);

--
-- 外部键约束
--
--
-- 索引
--

