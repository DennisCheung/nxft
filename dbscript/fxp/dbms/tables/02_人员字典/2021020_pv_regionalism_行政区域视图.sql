-- 行政区域视图

create or replace view pv_region_name as
select r.fregion_id    fregion_id,
       p.fregion_id    fprovince_id,
       p.fregion_code  fprovince_code,
       p.fregion_name  fprovince_name,
       p.fordernum     fprovince_ordernum,
       c.fregion_id    fcity_id,
       c.fregion_code  fcity_code,
       c.fregion_name  fcity_name,
       c.fordernum     fcity_ordernum,
       d.fregion_id    fdistrict_id,
       d.fregion_code  fdistrict_code,
       d.fregion_name  fdistrict_name,
       d.fordernum     fdistrict_ordernum,
       s.fregion_id    fstreet_id,
       s.fregion_code  fstreet_code,
       s.fregion_name  fstreet_name,
       s.fordernum     fstreet_ordernum,
       m.fregion_id    fcommittee_id,
       m.fregion_code  fcommittee_code,
       m.fregion_name  fcommittee_name,
       m.fordernum     fcommittee_ordernum,
       r.fversion      fversion,
       r.flogcby       flogcby,
       r.flogcdate     flogcdate,
       r.flogluby      flogluby,
       r.flogludate    flogludate,
       r.floglaby      floglaby,
       r.flogladate    flogladate
  from fxp.p_regionalism r left outer join fxp.p_regionalism p on r.fat_province_id = p.fregion_id
       left outer join fxp.p_regionalism c on r.fat_city_id = c.fregion_id
       left outer join fxp.p_regionalism d on r.fat_district_id = d.fregion_id
       left outer join fxp.p_regionalism s on r.fat_street_id = s.fregion_id
       left outer join fxp.p_regionalism m on r.fat_committee_id = m.fregion_id;


--
-- 同义词
--

--
-- 外部键约束
--
--
-- 授权
--
