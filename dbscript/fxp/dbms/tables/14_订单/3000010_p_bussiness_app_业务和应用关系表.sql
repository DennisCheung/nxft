--
-- ҵ���Ӧ�ù�ϵ��
--
-- v1.0 2017.03.04
-- author��wing
--
-- ˵��
--
-- 
-- �޸���ʷ��
--
-- drop table fxp.p_bussiness_app;
create table  fxp.p_bussiness_app (
-- +-----------------------------+--------------+-----------+
   fset_id                       varchar2(32)   not null,   -- ����ID
   fbusiness_id                  varchar2(32)   not null,   -- ҵ��id
   fapplication_id               varchar2(32)   not null,   -- Ӧ��id
   fset_desc                     varchar2(256),             -- ��ע
-- +-----------------------------+--------------+-----------+
   --
   -- ��־
   --
   fversion                      number(6)                  -- �汾��
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- ������
   flogcdate                     date           not null,   -- ����ʱ��
   flogluby                      varchar2(32)   not null,   -- ����޸���
   flogludate                    date           not null,   -- ����޸�ʱ��
   floglaby                      varchar2(32)   not null,   -- ��������
   flogladate                    date           not null,   -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_p_bussiness_app primary key (fset_id),
   constraint uk_p_bussiness_app unique (fbusiness_id,fapplication_id)
   --
   -- Լ��
   --
);

--
-- ͬ���
--

--
-- ��Ȩ
--

--
-- ����
--

--
-- �޸����
--
