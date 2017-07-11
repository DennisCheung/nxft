--
-- 电话区号表
--
--
-- v1.0 2015.03.25
-- author：wing
--
-- 修改历史：
--
--
-- drop table fxp.p_phone_areacode ;
create table  fxp.p_phone_areacode (
-- +-----------------------------+--------------+-----------+
   farea_code                    varchar2(20)   not null,   -- 区号
   fregion_id                    varchar2(32)   not null,   -- 行政区域ID
   farea_desc                    varchar2(256),             -- 备注
   --
   -- 日志
   --
   fversion                      number(6)                   -- 版本号
                                 default 0       not null,
   flogcby                       varchar2(32)
                                 default 'admin' not null,   -- 创建者
   flogcdate                     date
                                 default sysdate
                                 not null,   -- 创建时间
   flogluby                      varchar2(32)
                                 default 'admin'
                                 not null,   -- 最后修改者
   flogludate                    date
                                 default sysdate
                                 not null,   -- 最后修改时间
   floglaby                      varchar2(32)
                                 default 'admin'
                                 not null,   -- 最后访问者
   flogladate                    date
                                 default sysdate
                                 not null,   -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_p_phone_areacode primary key (farea_code)
);

--
-- 同义词
--
insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('020', '2951', '', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0660', '3036', '汕尾', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0662', '3046', '阳江', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0663', '3067', '揭阳', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0668', '3011', '茂名', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0750', '2995', '江门', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0751', '2965', '韶关', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0752', '3023', '惠州', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0753', '3028', '梅州', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0754', '4389', '汕头', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0755', '2974', '深圳', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0756', '2980', '珠海', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0757', '2990', '佛山', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0758', '4400', '肇庆', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0759', '3002', '湛江', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0760', '3061', '中山', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0762', '3040', '河源', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0763', '3050', '清远', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0766', '3074', '云浮', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0768', '3062', '潮州', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));

insert into fxp.p_phone_areacode (FAREA_CODE, FREGION_ID, FAREA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0769', '3060', '东莞', 0, 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('27-05-2015 15:44:47', 'dd-mm-yyyy hh24:mi:ss'));



commit ;

