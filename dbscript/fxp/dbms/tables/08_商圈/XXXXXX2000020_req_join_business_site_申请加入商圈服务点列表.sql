--
-- ���������Ȧ������б�
--
--
-- v1.0 2016.08.12
-- author��wing
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.req_join_business_site;
Create Table  fxp.req_join_business_site (
-- +-----------------------------+--------------+-----------+
   freqnote_id                   varchar2(32)   not null,   -- ���뵥id
   --
   -- ���뵥��Ϣ
   --
   fbusiness_circle_id           varchar2(32)   not null,   -- ��Ȧid
   foperator_id                  varchar2(32)   not null,   -- ��Ӫ��id
   fsupplier_id                  varchar2(32)   not null,   -- ������id
   fsite_id                      varchar2(32)   not null,   -- �����id
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
   constraint pk_req_join_business_site primary key (freqnote_id,fsite_id)
);



--
-- ͬ���
--
--
-- ��Ȩ
--

--
--����
--

--
-- �޸���䣺
--
--
