--
-- 用户签名表
--
-- v1.0 2015.11.09
-- author：wing
--
-- 修改历史：
--
-- drop table fxp.p_user_signature;
create table  fxp.p_user_signature (
-- +-----------------------------+--------------+-----------+
   fsignature_id                 varchar2(32)   not null,   -- 签名id
   fuser_id                      varchar2(32)   not null,   -- 用户id
   fsignature_content            varchar2(500)  not null,   -- 签名内容
   fsignature_date               date           not null,   -- 签名时间
-- +-----------------------------+--------------+-----------+
   fversion                      number(6)      not null,   -- 版本号
   --
   -- 主键、唯一键
   --
   constraint pk_p_user_signature primary key (fsignature_id)
   --
   -- 约束
   --
);

--
-- 授权
--

--
-- 索引
--

--
-- 修改语句
--
