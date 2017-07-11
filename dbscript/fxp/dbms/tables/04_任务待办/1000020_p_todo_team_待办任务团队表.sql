--
-- 待办团队表
--
-- v1.0 2015.11.04
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_todo_team;
Create Table  fxp.p_todo_team (
-- +-----------------------------+--------------+-----------+
   --
   -- 分配部门信息
   --
   ftodo_id                      varchar2(32)   not null,   -- 待办id
   fcreate_time                  date           not null,   -- 创建时间
   fcircle_id                    varchar2(32)   not null,   -- 工作圈id
   fteam_id                      varchar2(32)   not null,   -- 工作组id
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
   constraint pk_p_todo_team primary key (ftodo_id,fcircle_id,fteam_id)
);


--
--索引
--

--
-- 修改语句：
--
