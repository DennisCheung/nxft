--
-- 家庭来电识别表
--
-- v1.0 2016.10.09
-- author：wing
--
-- 说明
--
--
--
-- 修改历史：
--
-- drop table fxp.p_family_call_identify;
create table  fxp.p_family_call_identify (
-- +-----------------------------+--------------+-----------+
   fphone_number                 varchar2(30)   not null,   -- 电话号码
   ffamily_id                    varchar2(32)   not null,   -- 家庭id
   fis_default                   char(1) default 'Y'  not null, -- 是否默认
   fcreate_date                  date           not null,   -- 创建时间
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
   constraint pk_p_family_call_identify primary key (fphone_number,ffamily_id)
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
