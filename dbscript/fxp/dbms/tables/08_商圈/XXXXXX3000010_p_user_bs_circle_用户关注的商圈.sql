--
-- 用户关注的商圈表
--
-- v1.0 2016.08.27
-- author：wing
--
-- 说明
--
--
--
-- 修改历史：
--
-- drop table fxp.p_user_bs_circle;
create table  fxp.p_user_bs_circle (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- 用户ID
   fbusiness_circle_id           varchar2(32)   not null,   -- 商圈id
   fcreate_date                  date default sysdate not null, -- 创建时间（录入时输入的日期） 
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
   constraint pk_p_user_bs_circle primary key (fuser_id,fbusiness_circle_id)
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
