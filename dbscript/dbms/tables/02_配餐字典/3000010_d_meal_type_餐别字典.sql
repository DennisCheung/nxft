--
-- 餐别字典
--
-- v1.0 2017.03.27
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table nxft.d_meal_type;
create table  nxft.d_meal_type (
-- +-----------------------------+--------------+-----------+
   fmeal_type_id                 varchar2(32)   not null,   -- 餐别类型id
   fmeal_type_name               varchar2(40)   not null,   -- 餐别类型名称
   --
   -- 下单时间控制
   --
   fmeal_time                    varchar2(4)    not null,   -- 就餐时间  24YYMM
   forder_before                 number(2)      not null,   -- 下单提前小时数 
   forder_rule_desc              varchar2(256),             -- 规则描述  例如  晚上8：00前，可点次日早餐               
   fisavailable                  char(1)        not null,   -- 是否可用？
   fmeal_type_desc               varchar2(256),             -- 备注
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
   constraint pk_d_meal_type primary key (fmeal_type_id)
);

--
-- 同义词
--

--
-- 索引
--
