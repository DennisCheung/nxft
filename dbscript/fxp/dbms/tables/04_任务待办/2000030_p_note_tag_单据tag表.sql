--
-- 单据tag表
-- 
--
-- 说明：
-- 1、每个单据类型均为常量，对应相应的表名
--
--
-- v1.0 2015.11.04
-- author：wing
--
-- 修改历史：
--
--
-- Drop Table fxp.p_note_tag;
create Table  fxp.p_note_tag (
-- +-----------------------------+--------------+-----------+
   fnote_type_id                 varchar2(30)   not null,   -- 单据类型ID
   fnode_id                      varchar2(30)   not null,   -- 环节ID
   fnode_tag                     varchar2(128)  not null,   -- 环节tag
   ficon_file                    varchar2(30)   not null,   -- 图标文件名，如 abc.jpg  所有图标路径相同，由程序统一配置
   fblock_no                     varchar2(10)   not null,   -- 区号
   fordernum                     number(6,2)    not null,   -- 排序号
   ftag_desc                     varchar2(256),             -- 备注
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
   constraint pk_p_note_tag primary key (fnote_type_id,fnode_id,fnode_tag),
   constraint ck_p_note_tag_block   check (fblock_no in ('1','2'))
   );

--
-- 同义词
--

