--
-- 呼叫中心表
--
-- v1.0 2015.05.31
-- author：wing  
--
-- 修改历史：
-- 
--
--
-- Drop Table fxp.p_call_center;
Create Table  fxp.p_call_center (
-- +-----------------------------+--------------+-----------+
   fcall_center_id               varchar2(32)   not null,   -- 呼叫中心id
   fcall_center_code             varchar2(32)   not null,   -- 呼叫中心code  
   fcall_center_name             varchar2(100)  not null,   -- 呼叫中心名称
   forg_id                       varchar2(32)   not null,   -- 机构id
   fservice_num                  varchar2(20)   not null,   -- 统一呼出电话号码
   fcall_center_desc             varchar2(256),             -- 备注
   --
   -- 日志
   --
   fversion                      number(6)                   -- 版本号
                                 default 0       not null,
   flogcby                       varchar2(32)   not null,   -- 创建者
   flogcdate                     date           not null,   -- 创建时间
   flogluby                      varchar2(32)   not null,   -- 最后修改者
   flogludate                    date           not null,   -- 最后修改时间
   floglaby                      varchar2(32)   not null,   -- 最后访问者
   flogladate                    date           not null,   -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_p_call_center primary key (fcall_center_id),
   constraint uk_p_call_center_code unique (forg_id,fcall_center_code)
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

insert into p_call_center (FCALL_CENTER_ID, FCALL_CENTER_CODE, FCALL_CENTER_NAME, forg_id,fservice_num, FCALL_CENTER_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('1000101', '1000101', '番禺呼叫中心', '10001','4008517517', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_call_center (FCALL_CENTER_ID, FCALL_CENTER_CODE, FCALL_CENTER_NAME, forg_id,fservice_num, FCALL_CENTER_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('1000102', '1000102', '广州120急救中心', '10001','4008517517', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into p_call_center (FCALL_CENTER_ID, FCALL_CENTER_CODE, FCALL_CENTER_NAME, forg_id,fservice_num, FCALL_CENTER_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('1000201', '1000201', '佛山顺德呼叫中心', '10002','4008517517', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_call_center (FCALL_CENTER_ID, FCALL_CENTER_CODE, FCALL_CENTER_NAME, forg_id,fservice_num, FCALL_CENTER_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('1000301', '1000301', '佛山三水呼叫中心', '10003','4008517517', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;

