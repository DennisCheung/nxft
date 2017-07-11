--
-- 商品构成表
--
-- v1.0 2017.03.08
-- author：wing
--
-- 说明
--
-- 
-- 修改历史：
--
-- drop table fxp.p_goods_compose;
create table  fxp.p_goods_compose (
-- +-----------------------------+--------------+-----------+
   fcompose_id                   varchar2(32)   not null,   -- 构成ID
   fgoods_id                     varchar2(32)   not null,   -- 商品ID
   fproduct_id                   varchar2(32)   not null,   -- 服务目录ID
   fpercent                      number(4,1)    not null,   -- 所占百分比
   ffloating                     number(4,1)    not null,   -- 浮动百分比 
   fcompose_desc                 varchar2(256),             -- 备注
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
   constraint pk_p_goods_compose primary key (fgoods_id,fproduct_id)
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
