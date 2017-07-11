--
-- ��ƷͼƬ��
--
-- v1.0 2017.03.05
-- author��wing
--
-- �޸���ʷ��
--
-- v1.1
--   
-- drop table fxp.p_goods_pic;
create table  fxp.p_goods_pic (
-- +-----------------------------+--------------+-----------+
   fpicture_id                   varchar2(32)   not null,   -- ͼƬid
   fgoods_id                     varchar2(32)   not null,   -- ��ƷID
   fpicture_path                 varchar2(200)  not null,   -- ͼƬ·��
   fpicture_name                 varchar2(100)  not null,   -- ͼƬ�ļ���
   fpicturetype                  varchar2(10)   not null,   -- ͼƬ��ʽ��������JPG BMP PNG)
   fpicture_Desc                 varchar2(256),             -- ��ע
-- +-----------------------------+--------------+-----------+   
   --
   -- ��־
   --
   fversion                      number(6)                   -- �汾��
                                 default 0       not null,
   flogcby                       varchar2(32)   not null,   -- ������
   flogcdate                     date           not null,   -- ����ʱ��
   flogluby                      varchar2(32)   not null,   -- ����޸���
   flogludate                    date           not null,   -- ����޸�ʱ��
   floglaby                      varchar2(32)   not null,   -- ��������
   flogladate                    date           not null,   -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_p_goods_pic primary key (fpicture_id)
   --
   -- Լ��
   --
);


--
-- �ⲿ��Լ��
--

-- 
--���� 
--
create index fxp.idx_p_goods_pic_pic on fxp.p_goods_pic(fgoods_id);


--
-- �޸����
--

