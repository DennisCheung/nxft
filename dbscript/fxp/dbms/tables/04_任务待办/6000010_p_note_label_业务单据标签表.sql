--
-- 业务单据标签表
--
-- v1.0 2017.03.16
-- author：wing
--
-- 说明
--
--
--
-- 修改历史：
--
-- drop table fxp.p_note_label;
create table  fxp.p_note_label (
-- +-----------------------------+--------------+-----------+
   flabel_id                     varchar2(32)   not null,   -- 标签ID
   flabel_name                   varchar2(80)   not null,   -- 标签名称
   --
   -- 任务单据引用
   --
   fnote_type_id                 varchar2(30)   not null,   -- 单据类型ID    表头代名词
   fnote_id                      varchar2(150)  not null,   -- 业务要处理的单据主键,复合主键用逗号分隔   
   fcreate_time                  date           not null,   -- 创建时间
   fcreate_user_id               varchar2(32)   not null,   -- 创建工号id
   fcreate_nickname              varchar2(30)   not null,   -- 创建姓名
   flabel_desc                   varchar2(256),             -- 备注
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
   constraint pk_p_note_label primary key (flabel_id),
   constraint uk_p_note_label unique (fnote_type_id,fnote_id,flabel_name)
   --
   -- 约束
   --
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
-- 修改语句
--
