--
-- 运营商呼叫中心表
--
-- v1.0 2016.08.09
-- author：wing
--
-- 
-- 修改历史：
--
--
--
-- Drop Table fxp.p_oper_call_center;
Create Table  fxp.p_oper_call_center (
-- +-----------------------------+--------------+-----------+
   foperator_id                  varchar2(32)   not null,   -- 运营商id
   fcall_center_id               varchar2(32)   not null,   -- 呼叫中心id
   forg_id                       varchar2(32)   not null,   -- 机构id 
-- +-----------------------------+--------------+-----------+
   --
   -- 创建
   --
   fcreate_date                  date default sysdate not null, -- 创建日期（录入时输入的日期） 
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
   constraint pk_p_oper_call_center primary key (foperator_id,fcall_center_id)
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
