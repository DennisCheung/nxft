--
-- 应用实例
--
-- v1.0 2017.02.13
-- author：wing
--
-- 
-- 修改历史：
--
--
--
-- Drop Table fxp.p_app_instance;
Create Table  fxp.p_app_instance (
-- +-----------------------------+--------------+-----------+
   finstance_id                  varchar2(32)   not null,   -- 应用实例id
   finstance_name                varchar2(60)   not null,   -- 应用实例名称
   fcircle_id                    varchar2(32)   not null,   -- 工作圈id
   fapplication_id               varchar2(32)   not null,   -- 应用id
   fteam_id                      varchar2(32)   not null,   -- 工作组id
   finstance_desc                varchar2(256),             -- 备注 
-- +-----------------------------+--------------+-----------+
   --
   -- 创建者
   --
   fcreate_time                  date default sysdate not null, -- 创建时间 
   fcreate_user_id               varchar2(32)  not null,   -- 创建操作员id
   fcreate_user_name             varchar2(50)  not null,   -- 创建操作员姓名
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
   constraint pk_p_app_instance primary key (finstance_id),
   constraint uk_p_app_instance unique (fcircle_id,fapplication_id,fteam_id)
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
-- 修改语句：
--
