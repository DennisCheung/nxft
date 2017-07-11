--
-- 商品包含项目表
--
-- v1.0 2017.03.08
-- author：wing
--
-- 说明
--
-- 
-- 修改历史：
--
-- drop table fxp.p_goods_item;
create table  fxp.p_goods_item (
-- +-----------------------------+--------------+-----------+
   fgoods_id                     varchar2(32)   not null,   -- 商品ID
   fitem_id                      varchar2(32)   not null,   -- 服务产品ID
   fquantity                     number(6,0)    not null,   -- 数量
   fdesc                         varchar2(256),             -- 备注
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
   constraint pk_p_goods_item primary key (fgoods_id,fitem_id)
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
