--
-- Ʊ�ݺ��������������
-- 
-- 
--
-- v1.0 2017.03.02
-- author��wing
--
-- �޸���ʷ��
-- 
-- 
-- drop table fxp.p_id_bill_type ;
Create Table  fxp.p_id_bill_type (
-- +-----------------------------+--------------+-----------+
   fid                           varchar2(32)   not null,   -- id
   fclass_name                   varchar2(80)   not null,   -- ����
   fbill_type_id                 varchar2(32)   not null,   -- Ʊ������id
   fdesc                         varchar2(256),             -- ��ע 
-- +-----------------------------+--------------+-----------+
   --
   -- ��־
   --
   fversion                      number(6)                   -- �汾��
                                 default 0      not null,
   --
   -- ������Ψһ��
   --
   constraint pk_p_id_bill_type primary key (fid),
   constraint uk_p_id_bill_type_name unique (fclass_name)
);

--
-- ͬ���
--

-- com.wit.fxp.domain.model.qyhuser.QyhGuest, QYH_USER_ID
-- com.wit.fxp.domain.model.circle.Boss, BOSS_ID
-- com.wit.fxp.domain.model.circle.Circle, CIRCLE_ID
-- com.wit.fxp.domain.model.circle.Team, TEAM_ID

