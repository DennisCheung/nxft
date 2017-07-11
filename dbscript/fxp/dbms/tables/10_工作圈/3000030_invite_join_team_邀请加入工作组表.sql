--
-- 邀请加入工作组
--
--
-- v1.0 2017.02.27
-- author：wing
--
-- 修改历史：
--
--
-- Drop Table fxp.invite_join_team;
Create Table  fxp.invite_join_team (
-- +-----------------------------+--------------+-----------+
   finvite_id                    varchar2(32)   not null,   -- 邀请id
   fteam_id                      varchar2(32)   not null,   -- 工作组id
   fuser_id                      varchar2(32)   not null,   -- 用户id
   fcircle_id                    varchar2(32)   not null,   -- 工作圈id
   finvite_desc                  varchar2(256),             -- 邀请备注 
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
   constraint pk_invite_join_team primary key (finvite_id),
   constraint uk_invite_join_team_user unique (fteam_id,fuser_id)
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
