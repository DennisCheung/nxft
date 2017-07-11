--
-- 自动执行的待办任务项表
--
-- v1.0 2016.06.12
-- author：wing
--
-- 一、说明：
-- 1、机器自动执行任务待办
-- 2、此表记录用完立即删除。
--
-- 疑问：
--
--
-- 修改历史：
--
--
-- Drop Table fxp.p_todo_auto;
Create Table  fxp.p_todo_auto (
-- +-----------------------------+--------------+-----------+
   ftodo_id                      varchar2(32)   not null,   -- 待办id
   --
   -- 任务单据引用
   --
   fnote_type_id                 varchar2(30)   not null,   -- 单据类型ID    表头代名词
   fnote_id                      varchar2(150)  not null,   -- 任务要处理的单据主键,复合主键用逗号分隔
   --
   -- 任务说明
   --
   ftodo_content                 varchar2(300)  not null,   -- 任务内容     简要描述本环节工作内容   格式如何
   ftodo_remark                  varchar2(300),             -- 任务备注
   fcreate_time                  date           not null,   -- 创建时间
   fnode_id                      varchar2(30)   not null,   -- 环节ID
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
   constraint pk_p_todo_auto primary key (ftodo_id),
   constraint uk_p_todo_auto unique (fnote_type_id,fnote_id)
);


--
-- 同义词
--
--
-- 授权
--

--
--索引
--

--
-- 修改语句：
--

