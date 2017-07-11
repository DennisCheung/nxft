--
-- 配送单明细表
--
-- v1.0 2017.04.30
-- author：wing
--
-- 说明
--
-- 
-- 修改历史：
--
-- drop table nxft.delive_detail;
create table  nxft.delive_detail (
-- +-----------------------------+--------------+-----------+
   fdetail_id                    varchar2(32)   not null,   -- 明细ID
   --
   -- 菜谱
   --
   fmeal_id                      varchar2(32)   not null,   -- 套餐id
   fmeal_code                    varchar2(30)   not null,   -- 套餐CODE
   fmeal_name                    varchar2(40)   not null,   -- 套餐名称
   fquantity                     number(6,0)    not null,   -- 数量
   --
   -- 配送单
   --
   fdelive_note_id               varchar2(32),              -- 配送单id   
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
   constraint pk_delive_detail primary key (fdetail_id),
   constraint uk_delive_detail unique (fdelive_note_id,fmeal_id)
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
