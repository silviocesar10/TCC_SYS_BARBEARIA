--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: barbearia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.barbearia (
    id_barbearia integer NOT NULL,
    cnpj character varying(255),
    descricao character varying(255),
    email character varying(100),
    endereco character varying(255),
    nome character varying(50),
    senha character varying(255),
    telefone character varying(255)
);


ALTER TABLE public.barbearia OWNER TO postgres;

--
-- Name: barbearia_id_barbearia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.barbearia ALTER COLUMN id_barbearia ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.barbearia_id_barbearia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    id_cliente integer NOT NULL,
    cpf character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    endereco character varying(100),
    nome character varying(50) NOT NULL,
    senha character varying(50) NOT NULL,
    telefone character varying(255) NOT NULL
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- Name: cliente_id_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.cliente ALTER COLUMN id_cliente ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.cliente_id_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: recomendacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.recomendacao (
    id_recomendacao integer NOT NULL,
    data timestamp without time zone,
    id_cliente integer,
    id_servico_ofrc integer
);


ALTER TABLE public.recomendacao OWNER TO postgres;

--
-- Name: recomendacao_id_recomendacao_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.recomendacao ALTER COLUMN id_recomendacao ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.recomendacao_id_recomendacao_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: servico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.servico (
    id_servico integer NOT NULL,
    descricao character varying(200),
    nome_prod_serv character varying(255)
);


ALTER TABLE public.servico OWNER TO postgres;

--
-- Name: servico_id_servico_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.servico ALTER COLUMN id_servico ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.servico_id_servico_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: servico_oferecido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.servico_oferecido (
    id_servico_ofrc integer NOT NULL,
    id_barbearia integer,
    id_servico integer
);


ALTER TABLE public.servico_oferecido OWNER TO postgres;

--
-- Name: servico_oferecido_id_servico_ofrc_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.servico_oferecido ALTER COLUMN id_servico_ofrc ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.servico_oferecido_id_servico_ofrc_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: uso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.uso (
    id_uso integer NOT NULL,
    data_avaliacao timestamp without time zone,
    nota double precision NOT NULL,
    preco double precision NOT NULL,
    id_cliente integer,
    id_servico_ofrc integer
);


ALTER TABLE public.uso OWNER TO postgres;

--
-- Name: uso_id_uso_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.uso ALTER COLUMN id_uso ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.uso_id_uso_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: barbearia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.barbearia VALUES (1, '000000000000', 'empresa familiar', 'barbearia1@email.com', 'Cachoeiro', 'barbeariaDemo1', '123', '000000111');


--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cliente VALUES (1, '000.000.000-00', 'alberto@email.com', 'nova brasilia cachoeiro', 'Alberto', '123456', '000000000');
INSERT INTO public.cliente VALUES (2, '000.000.000-01', 'bianca@email.com', 'nova brasilia cachoeiro', 'Bianca', '123456', '000000000');
INSERT INTO public.cliente VALUES (3, '000.000.000-02', 'carlos@email.com', 'nova brasilia cachoeiro', 'Carlos', '123456', '000000000');
INSERT INTO public.cliente VALUES (4, '000.000.000-03', 'daniele@email.com', 'nova brasilia cachoeiro', 'Daniele', '123456', '000000000');
INSERT INTO public.cliente VALUES (5, '000.000.000-04', 'eder@email.com', 'nova brasilia cachoeiro', 'Eder', '123456', '000000000');


--
-- Data for Name: recomendacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.recomendacao VALUES (1, '2023-08-28 00:00:00', 2, 1);
INSERT INTO public.recomendacao VALUES (2, '2023-08-28 00:00:00', 3, 3);
INSERT INTO public.recomendacao VALUES (3, '2023-08-28 00:00:00', 4, 1);
INSERT INTO public.recomendacao VALUES (4, '2023-08-28 00:00:00', 4, 2);
INSERT INTO public.recomendacao VALUES (5, '2023-08-28 00:00:00', 4, 1);
INSERT INTO public.recomendacao VALUES (6, '2023-08-28 00:00:00', 4, 2);


--
-- Data for Name: servico; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.servico VALUES (1, 'servico 1', 'servico 1');
INSERT INTO public.servico VALUES (2, 'servico 2', 'servico 2');
INSERT INTO public.servico VALUES (3, 'servico 3', 'servico 3');
INSERT INTO public.servico VALUES (4, 'servico 4', 'servico 4');
INSERT INTO public.servico VALUES (5, 'servico 5', 'servico 5');


--
-- Data for Name: servico_oferecido; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.servico_oferecido VALUES (1, 1, 1);
INSERT INTO public.servico_oferecido VALUES (2, 1, 2);
INSERT INTO public.servico_oferecido VALUES (3, 1, 3);
INSERT INTO public.servico_oferecido VALUES (4, 1, 4);
INSERT INTO public.servico_oferecido VALUES (5, 1, 5);


--
-- Data for Name: uso; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.uso VALUES (1, '2020-10-09 21:00:00', 4.5, 10, 1, 1);
INSERT INTO public.uso VALUES (2, '2020-10-09 21:00:00', 4, 10, 1, 2);
INSERT INTO public.uso VALUES (3, '2020-10-09 21:00:00', 5, 10, 1, 3);
INSERT INTO public.uso VALUES (4, '2020-10-09 21:00:00', 3.5, 10, 1, 4);
INSERT INTO public.uso VALUES (5, '2020-10-09 21:00:00', 3.5, 10, 2, 2);
INSERT INTO public.uso VALUES (6, '2020-10-09 21:00:00', 1.5, 10, 2, 3);
INSERT INTO public.uso VALUES (7, '2020-10-09 21:00:00', 5, 10, 2, 4);
INSERT INTO public.uso VALUES (8, '2020-10-09 21:00:00', 4, 10, 2, 5);
INSERT INTO public.uso VALUES (9, '2020-10-09 21:00:00', 5, 10, 3, 1);
INSERT INTO public.uso VALUES (10, '2020-10-09 21:00:00', 3, 10, 3, 2);
INSERT INTO public.uso VALUES (11, '2020-10-09 21:00:00', 3.5, 10, 3, 4);
INSERT INTO public.uso VALUES (12, '2020-10-09 21:00:00', 4, 10, 4, 3);
INSERT INTO public.uso VALUES (13, '2020-10-09 21:00:00', 4, 10, 4, 4);
INSERT INTO public.uso VALUES (14, '2020-10-09 21:00:00', 2.5, 10, 4, 5);
INSERT INTO public.uso VALUES (15, '2020-10-09 21:00:00', 3, 10, 5, 1);
INSERT INTO public.uso VALUES (16, '2020-10-09 21:00:00', 4, 10, 5, 2);
INSERT INTO public.uso VALUES (17, '2020-10-09 21:00:00', 2, 10, 5, 3);
INSERT INTO public.uso VALUES (18, '2020-10-09 21:00:00', 2, 10, 5, 5);


--
-- Name: barbearia_id_barbearia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.barbearia_id_barbearia_seq', 1, true);


--
-- Name: cliente_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_id_cliente_seq', 5, true);


--
-- Name: recomendacao_id_recomendacao_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.recomendacao_id_recomendacao_seq', 6, true);


--
-- Name: servico_id_servico_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.servico_id_servico_seq', 5, true);


--
-- Name: servico_oferecido_id_servico_ofrc_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.servico_oferecido_id_servico_ofrc_seq', 5, true);


--
-- Name: uso_id_uso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.uso_id_uso_seq', 18, true);


--
-- Name: barbearia barbearia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.barbearia
    ADD CONSTRAINT barbearia_pkey PRIMARY KEY (id_barbearia);


--
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente);


--
-- Name: recomendacao recomendacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recomendacao
    ADD CONSTRAINT recomendacao_pkey PRIMARY KEY (id_recomendacao);


--
-- Name: servico_oferecido servico_oferecido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servico_oferecido
    ADD CONSTRAINT servico_oferecido_pkey PRIMARY KEY (id_servico_ofrc);


--
-- Name: servico servico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servico
    ADD CONSTRAINT servico_pkey PRIMARY KEY (id_servico);


--
-- Name: uso uso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.uso
    ADD CONSTRAINT uso_pkey PRIMARY KEY (id_uso);


--
-- Name: uso fkef31tnjndpjxyivvvk5hso0t0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.uso
    ADD CONSTRAINT fkef31tnjndpjxyivvvk5hso0t0 FOREIGN KEY (id_servico_ofrc) REFERENCES public.servico_oferecido(id_servico_ofrc);


--
-- Name: recomendacao fkeksknlx4i90h2bs82msng4a6s; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recomendacao
    ADD CONSTRAINT fkeksknlx4i90h2bs82msng4a6s FOREIGN KEY (id_cliente) REFERENCES public.cliente(id_cliente);


--
-- Name: servico_oferecido fkhegm1237v1y22c5rjhefk4rp3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servico_oferecido
    ADD CONSTRAINT fkhegm1237v1y22c5rjhefk4rp3 FOREIGN KEY (id_barbearia) REFERENCES public.barbearia(id_barbearia);


--
-- Name: servico_oferecido fkigy7vg2i9p2ja1rs9fv4alga5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servico_oferecido
    ADD CONSTRAINT fkigy7vg2i9p2ja1rs9fv4alga5 FOREIGN KEY (id_servico) REFERENCES public.servico(id_servico);


--
-- Name: uso fkjhvdncmiwdbg9w5beqfw243gr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.uso
    ADD CONSTRAINT fkjhvdncmiwdbg9w5beqfw243gr FOREIGN KEY (id_cliente) REFERENCES public.cliente(id_cliente);


--
-- Name: recomendacao fkq4ko14l2wg7nu9fbux1ivo2ty; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recomendacao
    ADD CONSTRAINT fkq4ko14l2wg7nu9fbux1ivo2ty FOREIGN KEY (id_servico_ofrc) REFERENCES public.servico_oferecido(id_servico_ofrc);


--
-- PostgreSQL database dump complete
--

