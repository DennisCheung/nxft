--
-- 暖心饭堂对象短信日志
--
-- v1.0 2017.06.12
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table nxft.nxft_subject_sms_log;
Create Table  nxft.nxft_subject_sms_log (
-- +-----------------------------+--------------+-----------+
   fsms_id                       varchar2(32)   not null,   -- 短信id    
   --
   -- 通讯服务商
   --
   ftsp_name                     varchar2(30)   not null,   -- 通讯服务商如：云之讯、容联 协同通讯
   --
   -- 对象信息
   --
   fsubject_id                   varchar2(32)   not null,   -- 监测对象ID   
   fsubject_name                 varchar2(50)   not null,   -- 对象姓名
   fcircle_id                    varchar2(32)   not null,   -- 客户所属的工作圈id
   --
   -- 短信信息
   --
   fcreate_time                  date           not null,   -- 创建时间
   fsms_content                  varchar2(1000) not null,   -- 短信内容
   fsms_type                     varchar2(32)   not null,   -- 短信类型  TEXT  文字短信  VOICE  语音短信
   fsms_desc                     varchar2(256),             -- 业务说明,如 坐席订餐、助餐点订餐   
   --
   -- 短信接收人
   --
   fto_number                    varchar2(20)   not null,   -- 客户电话号码   
   fto_name                      varchar2(40)   not null,   -- 短信接收人姓名
   frelation_name                varchar2(30),              -- 与对象关系name，本人或对象联系人关系         
   --
   -- 操作员信息
   --
   fuser_circle_id               varchar2(32),              -- 操作员圈id
   fuser_team_id                 varchar2(32),              -- 操作员工作组id
   fuser_user_id                 varchar2(32)   not null,   -- 操作员id
   fuser_nickname                varchar2(40)   not null,   -- 操作员姓名
-- +-----------------------------+--------------+-----------+
   --
   -- 日志
   --
   fversion                      number(6)                  -- 版本号
                                 default 0      not null,   
   --
   -- 主键、唯一键
   --
   constraint pk_nxft_subject_sms_log primary key (fsms_id)
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
create index nxft.idx_nxft_subject_sms_log1 on nxft.nxft_subject_sms_log(fcreate_time);
create index nxft.idx_nxft_subject_sms_log2 on nxft.nxft_subject_sms_log(fsubject_id);
--
-- 修改语句：
--
