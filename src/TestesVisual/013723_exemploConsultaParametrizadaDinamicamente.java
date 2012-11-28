	@SuppressWarnings("unchecked")
	public List<Classe> findParametrizado(String param1, String param2, String param3) {
		EntityManagerHelper.log("finding all Abastecimento instances",
				Level.INFO, null);
		try {
			final String queryString = "select * from tabela ";
			boolean temWhere=false;
			if (param1.length()>0){
				queryString += "where param1="+param1;
				temWhere=true;
			}
			if (param2.length()>0){
				if (!temWhere){
					queryString += " where ";
				}
				queryString += " param2="+param2;
				temWhere=true;
			}
			if (param3.length()>0){
				if (!temWhere){
					queryString += " where ";
				}
				queryString += " param3="+param3;
				temWhere=true;
			}
			Query query = getEntityManager().createNativeQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}
