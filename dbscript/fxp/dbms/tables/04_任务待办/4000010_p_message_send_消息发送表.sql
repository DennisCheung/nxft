--
-- 消息发送表
--
-- v1.0 2016.09.07
-- author：wing
--
-- 说明
-- 1、后台作业定时轮询消息发送表，并调用微信企业号发送消息接口
-- 2、消息发送完毕后，将消息迁移到p_message_history
-- 3、阅读消息，链接查询 p_message_history
--
--
-- 修改历史：
--
--
-- Drop Table fxp.p_message_send;
Create Table  fxp.p_message_send (
-- +-----------------------------+--------------+-----------+
   fmessage_id                   varchar2(32)   not null,   -- 消息id
   --
   -- 消息单据引用
   --
   fnote_type_id                 varchar2(30)   not null,   -- 单据类型ID    表头代名词
   fnote_id                      varchar2(150)  not null,   -- 任务要处理的单据主键,复合主键用逗号分隔
   --
   -- 消息说明
   --
   fmessage_title                varchar2(300)  not null,   -- 消息标题
   fmessage_content              varchar2(300)  not null,   -- 消息内容     简要描述本环节工作内容
   fnode_id                      varchar2(30)   not null,   -- 环节ID
   --
   -- 发送
   --
   fsend_time                    date           not null,   -- 发送时间
   fsend_circle_id               varchar2(32),              -- 发送工作圈id
   fsend_team_id                 varchar2(32),              -- 发送工作组id
   fsend_user_id                 varchar2(32)   not null,   -- 发送操作员id
   --
   -- 接收
   --
   freceive_circle_id            varchar2(32),              -- 接收工作圈id
   freceive_team_id              varchar2(32),              -- 接收工作组id
   freceive_user_id              varchar2(32)   not null,   -- 接收操作员id
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
   constraint pk_p_message_send primary key (fmessage_id),
   constraint uk_p_message_send unique (fnote_type_id,fnote_id)
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

