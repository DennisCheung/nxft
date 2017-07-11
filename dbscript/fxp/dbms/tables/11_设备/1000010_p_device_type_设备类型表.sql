--
-- 设备类型表
--
-- v1.0 2016.09.10
-- author：wing
-- 
--
-- 修改历史：
-- 
--
--  
-- drop table fxp.p_device_type;
create table  fxp.p_device_type (
-- +-----------------------------+--------------+-----------+
   fdevice_type_id               varchar2(32)   not null,   -- 设备类型_id   常量  WRISTBAND 手环  CALL 呼叫器 TEH 定位手表
   fdevice_type_name             varchar2(50)   not null,   -- 设备类型名称
   fdevice_type_desc             varchar2(256),             -- 备注   
   --
   -- 创建者
   --
   fcreate_date                  date           not null,   -- 创建时间  
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
   constraint pk_p_device_type primary key (fdevice_type_id)
);

--
-- 外部键约束
--
--
-- 授权
--
