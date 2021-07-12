package fo.us.folkv3.api.client;

import java.util.Objects;
import java.util.regex.Pattern;

import fo.us.folkv3.api.client.HeldinConfig.Identifier.Env;
import fo.us.folkv3.api.client.HeldinConfig.Identifier.MemberClass;

public class HeldinConfig {

	private static final Identifier DEFAULT_SERVICE = Identifier.parse("FO/GOV/405388/FOLK-V3");
	
	public final String host;
	public final boolean secure;
	public final Identifier service;
	public final Identifier client;
	public final String userId;

	private HeldinConfig(String host, boolean secure, Identifier service, Identifier client, String userId) {
		this.host = Objects.requireNonNull(host, "host");
		this.secure = secure;
		this.service = Objects.requireNonNull(service, "service");
		this.client = Objects.requireNonNull(client, "client");
		this.userId = userId;
	}

	public static HeldinConfig of(String host, boolean secure, String clientPath) {
		return of(host, secure, Identifier.parse(clientPath));
	}

	public static HeldinConfig of(String host, boolean secure, Identifier clientIdentifier) {
		var serviceIdentifier = clientIdentifier.prod ? DEFAULT_SERVICE : DEFAULT_SERVICE.withEnv(clientIdentifier);
		return new HeldinConfig(host, secure, serviceIdentifier, clientIdentifier, null);
	}

	public static B0 host(String host) {
		return new Builder(host, false);
	}
	
	public static B0 secureHost(String host) {
		return new Builder(host, true);
	}
	
	public HeldinConfig withUserId(String userId) {
		return new HeldinConfig(host, secure, service, client, userId);
	}
	
	@Override
	public String toString() {
		return "host: " + host + "; secure: " + secure + "; service: " + service + "; client: " + client + "; userId: " + userId;
	}

	public static interface B0 {
		B1 fo();
	}
	public static interface B1 {
		B2 dev();
		B2 test();
		B2 prod();
	}
	public static interface B2 {
		B3 com();
		B3 gov();
	}
	public static interface B3 {
		B4 memberCode(String memberCode);
	}
	public static interface B4 {
		HeldinConfig subSystemCode(String subSystemCode);
		default HeldinConfig noSubSystemCode() {
			return subSystemCode(null);
		}
	}
	public static class Builder implements B0, B1, B2, B3, B4 {
		private String host;
		private boolean secure;
		private String xRoadInstancePrefix;
		private Env env;
		private MemberClass memberClass;
		private String memberCode;
		Builder(String host, boolean secure) {
			this.host = host;
			this.secure = secure;
		}
		@Override
		public B1 fo() {
			xRoadInstancePrefix = "FO";
			return this;
		}
		@Override
		public B2 dev() {
			env = Env.DEV;
			return this;
		}
		@Override
		public B2 test() {
			env = Env.TEST;
			return this;
		}
		@Override
		public B2 prod() {
			env = Env.PROD;
			return this;
		}
		@Override
		public B3 com() {
			memberClass = MemberClass.COM;
			return this;
		}
		@Override
		public B3 gov() {
			memberClass = MemberClass.GOV;
			return this;
		}
		@Override
		public B4 memberCode(String memberCode) {
			this.memberCode = memberCode;
			return this;
		}
		@Override
		public HeldinConfig subSystemCode(String subSystemCode) {
			return HeldinConfig.of(host, secure,
					new Identifier(xRoadInstancePrefix, env, memberClass, memberCode, subSystemCode));
		}
	}
	
	public static class Identifier {
		private static Pattern pattern = Pattern.compile("/");
		public final String xRoadInstancePrefix;
		private final Env env; 
		public final MemberClass memberClass;
		public final String memberCode;
		public final String subSystemCode;
		public final String xRoadInstance;
		public final String path;
		public final boolean dev;
		public final boolean test;
		public final boolean prod;
		private Identifier(String xRoadInstancePrefix, Env env, MemberClass memberClass, String memberCode,
				String subSystemCode) {
			this.xRoadInstancePrefix = xRoadInstancePrefix;
			this.env = env;
			this.memberClass = memberClass;
			this.memberCode = memberCode;
			this.subSystemCode = subSystemCode;
			xRoadInstance = xRoadInstancePrefix + (env == Env.PROD ? "" : '-' + env.value);
			path = xRoadInstance + '/' + memberClass + '/' + memberCode
					+ (subSystemCode == null || subSystemCode.isBlank() ? "" : '/' + subSystemCode);
			dev = env == Env.DEV;
			test = env == Env.TEST;
			prod = env == Env.PROD;
		}
		private static Identifier parse(String path) {
			var parts = identifierParts(path);
			var xRoadInstance = parts[0];
			var memberClass = MemberClass.valueOf(parts[1]);
			var memberCode = parts[2];
			var subSystemCode = parts[3];
			var envSepIdx = xRoadInstance.indexOf('-');
			var xRoadInstancePrefix = envSepIdx == -1 ? xRoadInstance : xRoadInstance.substring(0, envSepIdx);
			var env = Env.of(envSepIdx == -1 ? "" : xRoadInstance.substring(envSepIdx + 1));
			return new Identifier(xRoadInstancePrefix, env, memberClass, memberCode, subSystemCode);
		}
		public Identifier withEnv(Identifier identifier) {
			return new Identifier(xRoadInstancePrefix, identifier.env, memberClass, memberCode, subSystemCode);
		}
		@Override
		public String toString() {
			return path;
		}
		private static String[] identifierParts(String path) {
			var parts = pattern.split(path);
			if (parts.length != 4) {
				throw new IllegalArgumentException(
						"path has to be of the form xRoadInstance/memberClass/memberCode/subSystemCode - actual "
						+ path);
			}
			return parts;
		}
		public static enum Env {
			DEV("DEV"), TEST("TST"), PROD("");
			public final String value;
			private Env(String value) {
				this.value = value;
			}
			public static Env of(String value) {
				if (value.equals(DEV.value)) return DEV;
				if (value.equals(TEST.value)) return TEST;
				if (value.equals(PROD.value)) return PROD;
				throw new IllegalArgumentException("Illegal value: " + value);
			}
		}
		public static enum MemberClass {
			COM, GOV;
		}
	}
	
}
