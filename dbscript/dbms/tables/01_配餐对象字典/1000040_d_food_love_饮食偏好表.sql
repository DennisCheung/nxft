--
-- 饮食偏好表
--
-- v1.0 2017.06.01
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table nxft.d_food_love;
create table  nxft.d_food_love (
-- +-----------------------------+--------------+-----------+
   ffood_love_id                 varchar2(32)   not null,   -- 饮食偏好ID
   ffood_love_code               varchar2(8)    not null,   -- 饮食偏好代码
   ffood_love_name               varchar2(40)   not null,   -- 饮食偏好名称
   fisother                      char(1)        not null,   -- 是否是其他项 Y/N  其他项需手工输入备注 
   ffood_love_desc               varchar2(256),             -- 备注
-- +-----------------------------+--------------+-----------+
   --
   -- 日志
   --
   fversion                      number(6)                   -- 版本号
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
   constraint pk_d_food_love primary key (ffood_love_id)
);

--
-- 同义词
--
