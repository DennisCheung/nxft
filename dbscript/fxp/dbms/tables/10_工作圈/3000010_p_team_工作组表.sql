--
-- 工作组表
--
-- v1.0 2017.02.13
-- author：wing
--
-- 
-- 修改历史：
--
--
--
-- Drop Table fxp.p_team;
Create Table  fxp.p_team (
-- +-----------------------------+--------------+-----------+
   fteam_id                      varchar2(32)   not null,   -- 工作组id
   fteam_name                    varchar2(100)  not null,   -- 工作组名称
   fapplication_id               varchar2(32)   not null,   -- 应用id
   fcircle_id                    varchar2(32)   not null,   -- 工作圈id
   fregion_id                    varchar2(32),              -- 行政区域ID
   fregion_name                  varchar2(80),              -- 行政区域名称
   faddress                      varchar2(200),             -- 详细地址
   fcontact_person               varchar2(30),              -- 联系人
   fcontact_mobile               varchar2(30),              -- 联系手机
   fisavailable                  char(1)        not null,   -- 是否可用？
   fteam_desc                    varchar2(256),             -- 备注 
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
   constraint pk_p_team primary key (fteam_id),
   constraint uk_p_team_circle unique (fteam_id,fcircle_id),
   constraint uk_p_team_name unique (fteam_name,fcircle_id)
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
