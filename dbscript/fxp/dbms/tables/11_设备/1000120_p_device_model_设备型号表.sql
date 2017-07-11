--
-- 设备型号表
--
-- v1.0 2016.10.09
-- author：wing
-- 
--
-- 修改历史：
-- 
--
--  
-- drop table fxp.p_device_model;
create table  fxp.p_device_model (
-- +-----------------------------+--------------+-----------+
   fdevice_model_id              varchar2(32)   not null,   -- 设备型号_id
   fdevice_model_code            varchar2(30)   not null,   -- 设备型号_code
   fdevice_model_name            varchar2(50)   not null,   -- 设备型号名称
   fcompany_id                   varchar2(32)   not null,   -- 设备厂商_id
   fcompany_name                 varchar2(30)   not null,   -- 设备厂商 NAME
   fdevice_type_id               varchar2(32)   not null,   -- 设备类型_id
   fdevice_type_name             varchar2(50)   not null,   -- 设备类型名称 
   fmax_user                     number(3,0)    not null,   -- 设备最大用户数，默认为1
   fdevice_model_desc            varchar2(256),             -- 备注   
   --
   -- 创建者
   --
   fcreate_date                  date           not null,   -- 创建时间  
   fcreate_user_id               varchar2(32)   not null,   -- 创建操作员id
   fcreate_nickname              varchar2(40)   not null,   -- 创建操作员姓名
  --
   -- 注销
   --
   fis_cancel                    char(1) default 'N'  not null, -- 是否被注销
   fcancel_reason                varchar2(100),             -- 注销原因
   fcancel_date                  date,                      -- 注销机器时间
   fcancel_user_id               varchar2(32),              -- 注销操作员id
   fcancel_nickname              varchar2(40),              -- 注销操作员姓名 
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
   constraint pk_p_device_model primary key (fdevice_model_id),
   constraint uk_p_device_model unique (fdevice_model_code)
);

--
-- 外部键约束
--
--
-- 授权
--
