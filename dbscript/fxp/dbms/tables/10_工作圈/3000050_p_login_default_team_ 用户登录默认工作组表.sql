--
-- 用户登录默认工作组表
--
-- v1.0 2017.06.06
-- author：wing
--
-- 说明：
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_login_default_team;
Create Table  fxp.p_login_default_team (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- 主键id
   fuser_id                      varchar2(32)   not null,   -- 操作员id
   fapplication_id               varchar2(32)   not null,   -- 应用id
   fcircle_id                    varchar2(32)   not null,   -- 工作圈id
   fteam_id                      varchar2(32)   not null,   -- 工作组id
   fdesc                         varchar2(256),             -- 备注
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
   constraint pk_p_login_default_team primary key (fpk_id),
   constraint uk_p_login_default_team unique (fuser_id,fapplication_id)
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
