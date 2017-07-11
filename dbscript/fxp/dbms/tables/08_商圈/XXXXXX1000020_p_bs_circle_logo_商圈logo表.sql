--
-- 商圈logo表
--
-- v1.0 2016.08.18
-- author：
--
-- 修改历史：
--
-- drop table fxp.p_bs_circle_logo;
create table  fxp.p_bs_circle_logo (
-- +-----------------------------+--------------+-----------+
   fbusiness_circle_id           varchar2(32)   not null,   -- 商圈id
   flogo                         blob           not null,   -- 头像图片
   flogo_type                    varchar2(8)    not null,   -- 头像图片类型
   flogo_size                    number(8)      not null,   -- 头像字节大小
   flogo_date                    date           not null,   -- 头像日期
-- +-----------------------------+--------------+-----------+
   fversion                      number(6)      not null,   -- 版本号
   --
   -- 主键、唯一键
   --
   constraint pk_p_bs_circle_logo primary key (fbusiness_circle_id)
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
