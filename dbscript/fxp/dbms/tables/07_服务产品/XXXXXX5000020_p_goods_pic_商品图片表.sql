--
-- 商品图片表
--
-- v1.0 2017.03.05
-- author：wing
--
-- 修改历史：
--
-- v1.1
--   
-- drop table fxp.p_goods_pic;
create table  fxp.p_goods_pic (
-- +-----------------------------+--------------+-----------+
   fpicture_id                   varchar2(32)   not null,   -- 图片id
   fgoods_id                     varchar2(32)   not null,   -- 商品ID
   fpicture_path                 varchar2(200)  not null,   -- 图片路径
   fpicture_name                 varchar2(100)  not null,   -- 图片文件名
   fpicturetype                  varchar2(10)   not null,   -- 图片格式（常量：JPG BMP PNG)
   fpicture_Desc                 varchar2(256),             -- 备注
-- +-----------------------------+--------------+-----------+   
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
   constraint pk_p_goods_pic primary key (fpicture_id)
   --
   -- 约束
   --
);


--
-- 外部键约束
--

-- 
--索引 
--
create index fxp.idx_p_goods_pic_pic on fxp.p_goods_pic(fgoods_id);


--
-- 修改语句
--

