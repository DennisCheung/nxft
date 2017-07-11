--
-- 单据类型表
--
-- 说明：
--
--
-- v1.0 2015.11.04
-- author：wing
--
-- 修改历史：
--
--
-- Drop Table fxp.p_note_type;
create Table  fxp.p_note_type (
-- +-----------------------------+--------------+-----------+
   fnote_type_id                 varchar2(32)   not null,   -- 单据类型ID
   fnote_type_name               varchar2(40)   not null,   -- 单据类型NAME
   fordernum                     number(6,2)    not null,   -- 排序号
   fnote_type_desc               varchar2(256),             -- 备注
   --
   -- 日志
   --
   fversion                      number(6)                  -- 版本号
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- 创建者
   flogcdate                     date default sysdate not null,   -- 创建时间
   flogluby                      varchar2(32)   not null,   -- 最后修改者
   flogludate                    date default sysdate not null,   -- 最后修改时间
   floglaby                      varchar2(32)   not null,   -- 最后访问者
   flogladate                    date default sysdate not null,   -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_p_note_type primary key (fnote_type_id)
);

