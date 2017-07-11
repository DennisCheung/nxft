--
-- 待办任务项表
--
-- v1.0 2015.11.03
-- author：wing
--
-- 一、说明：
-- 1、待办任务用于业务与流程衔接用，为一项业务两个环节之间沟通的桥梁。
-- 2、待办任务起到通知下一个环节，并作为下一个环节开始工作的入口。
-- 3、“发送”填的是下一环节的任务
-- 4、此表记录用完立即删除。
--
-- 疑问：
-- 1、fnote_type 单据类型 是否可以理解为业务类型。
-- 2、fnode_id   对于有多个环节的业务可以理解为环节，对于只有一个环节的业务是否可以理解为 业务子类型，如呼叫类型 或 回访病种。
-- 3、回访是否只有一个环节？
--
--
-- 修改历史：
--
--
-- Drop Table fxp.p_todo;
Create Table  fxp.p_todo (
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
   fnote_tag                     varchar2(128)  not null,   -- 单据tag 如无意义时填 'DEFAULT'
   ficon_file                    varchar2(30)   not null,   -- 图标文件名，如 abc.jpg  所有图标路径相同，由程序统一配置
   fblock_no                     varchar2(10)   not null,   -- 区号
   fordernum                     number(6,2)    not null,   -- 排序号
   --
   -- 抢单
   --
   fis_grabbed                   char(1)        not null,   -- 是否被抢单？  Y/N
   fgrab_time                    date,                      -- 抢单时间
   fgrab_circle_id               varchar2(32),              -- 抢单工作圈id
   fgrab_team_id                 varchar2(32),              -- 抢单工作组id
   fgrab_user_id                 varchar2(32),              -- 抢单操作员id
   fgrab_user_name               varchar2(40),              -- 抢单操作员姓名
   --
   -- 客户信息
   --
   fperson_id                    varchar2(32),              -- 居民ID
   fperson_name                  varchar2(50),              -- 居民姓名
   ffamily_id                    varchar2(32),              -- 家庭id
   fcircle_id                    varchar2(32),              -- 工作圈id 
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
   constraint pk_p_todo primary key (ftodo_id),
   constraint uk_p_todo unique (fnote_type_id,fnote_id)
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

