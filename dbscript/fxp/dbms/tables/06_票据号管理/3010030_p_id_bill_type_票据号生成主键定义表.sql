--
-- 票据号生成主键定义表
-- 
-- 
--
-- v1.0 2017.03.02
-- author：wing
--
-- 修改历史：
-- 
-- 
-- drop table fxp.p_id_bill_type ;
Create Table  fxp.p_id_bill_type (
-- +-----------------------------+--------------+-----------+
   fid                           varchar2(32)   not null,   -- id
   fclass_name                   varchar2(80)   not null,   -- 类名
   fbill_type_id                 varchar2(32)   not null,   -- 票据类型id
   fdesc                         varchar2(256),             -- 备注 
-- +-----------------------------+--------------+-----------+
   --
   -- 日志
   --
   fversion                      number(6)                   -- 版本号
                                 default 0      not null,
   --
   -- 主键、唯一键
   --
   constraint pk_p_id_bill_type primary key (fid),
   constraint uk_p_id_bill_type_name unique (fclass_name)
);

--
-- 同义词
--

-- com.wit.fxp.domain.model.qyhuser.QyhGuest, QYH_USER_ID
-- com.wit.fxp.domain.model.circle.Boss, BOSS_ID
-- com.wit.fxp.domain.model.circle.Circle, CIRCLE_ID
-- com.wit.fxp.domain.model.circle.Team, TEAM_ID

