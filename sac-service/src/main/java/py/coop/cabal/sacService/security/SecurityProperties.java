package py.coop.cabal.sacService.security;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;

@Component
@Configuration
@ConfigurationProperties(prefix = "rest.security")
public class SecurityProperties {

	private boolean enabled;
	private String apiMatcher;
	private Cors cors;
	private String issuerUri;

	public CorsConfiguration getCorsConfiguration() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedOrigins(cors.getAllowedOrigins());
		corsConfiguration.setAllowedMethods(cors.getAllowedMethods());
		corsConfiguration.setAllowedHeaders(cors.getAllowedHeaders());
		corsConfiguration.setExposedHeaders(cors.getExposedHeaders());
		corsConfiguration.setAllowCredentials(cors.getAllowCredentials());
		corsConfiguration.setMaxAge(cors.getMaxAge());

		return corsConfiguration;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getApiMatcher() {
		return apiMatcher;
	}

	public void setApiMatcher(String apiMatcher) {
		this.apiMatcher = apiMatcher;
	}

	public Cors getCors() {
		return cors;
	}

	public void setCors(Cors cors) {
		this.cors = cors;
	}

	public String getIssuerUri() {
		return issuerUri;
	}

	public void setIssuerUri(String issuerUri) {
		this.issuerUri = issuerUri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apiMatcher == null) ? 0 : apiMatcher.hashCode());
		result = prime * result + ((cors == null) ? 0 : cors.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((issuerUri == null) ? 0 : issuerUri.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "SecurityProperties [enabled=" + enabled + ", apiMatcher=" + apiMatcher + ", cors=" + cors
				+ ", issuerUri=" + issuerUri + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SecurityProperties other = (SecurityProperties) obj;
		if (apiMatcher == null) {
			if (other.apiMatcher != null)
				return false;
		} else if (!apiMatcher.equals(other.apiMatcher))
			return false;
		if (cors == null) {
			if (other.cors != null)
				return false;
		} else if (!cors.equals(other.cors))
			return false;
		if (enabled != other.enabled)
			return false;
		if (issuerUri == null) {
			if (other.issuerUri != null)
				return false;
		} else if (!issuerUri.equals(other.issuerUri))
			return false;
		return true;
	}

	public static class Cors {

		private List<String> allowedOrigins;
		private List<String> allowedMethods;
		private List<String> allowedHeaders;
		private List<String> exposedHeaders;
		private Boolean allowCredentials;
		private Long maxAge;

		public List<String> getAllowedOrigins() {
			return allowedOrigins;
		}

		public void setAllowedOrigins(List<String> allowedOrigins) {
			this.allowedOrigins = allowedOrigins;
		}

		public List<String> getAllowedMethods() {
			return allowedMethods;
		}

		public void setAllowedMethods(List<String> allowedMethods) {
			this.allowedMethods = allowedMethods;
		}

		public List<String> getAllowedHeaders() {
			return allowedHeaders;
		}

		public void setAllowedHeaders(List<String> allowedHeaders) {
			this.allowedHeaders = allowedHeaders;
		}

		public List<String> getExposedHeaders() {
			return exposedHeaders;
		}

		public void setExposedHeaders(List<String> exposedHeaders) {
			this.exposedHeaders = exposedHeaders;
		}

		public Boolean getAllowCredentials() {
			return allowCredentials;
		}

		public void setAllowCredentials(Boolean allowCredentials) {
			this.allowCredentials = allowCredentials;
		}

		public Long getMaxAge() {
			return maxAge;
		}

		public void setMaxAge(Long maxAge) {
			this.maxAge = maxAge;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((allowCredentials == null) ? 0 : allowCredentials.hashCode());
			result = prime * result + ((allowedHeaders == null) ? 0 : allowedHeaders.hashCode());
			result = prime * result + ((allowedMethods == null) ? 0 : allowedMethods.hashCode());
			result = prime * result + ((allowedOrigins == null) ? 0 : allowedOrigins.hashCode());
			result = prime * result + ((exposedHeaders == null) ? 0 : exposedHeaders.hashCode());
			result = prime * result + ((maxAge == null) ? 0 : maxAge.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cors other = (Cors) obj;
			if (allowCredentials == null) {
				if (other.allowCredentials != null)
					return false;
			} else if (!allowCredentials.equals(other.allowCredentials))
				return false;
			if (allowedHeaders == null) {
				if (other.allowedHeaders != null)
					return false;
			} else if (!allowedHeaders.equals(other.allowedHeaders))
				return false;
			if (allowedMethods == null) {
				if (other.allowedMethods != null)
					return false;
			} else if (!allowedMethods.equals(other.allowedMethods))
				return false;
			if (allowedOrigins == null) {
				if (other.allowedOrigins != null)
					return false;
			} else if (!allowedOrigins.equals(other.allowedOrigins))
				return false;
			if (exposedHeaders == null) {
				if (other.exposedHeaders != null)
					return false;
			} else if (!exposedHeaders.equals(other.exposedHeaders))
				return false;
			if (maxAge == null) {
				if (other.maxAge != null)
					return false;
			} else if (!maxAge.equals(other.maxAge))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Cors [allowedOrigins=" + allowedOrigins + ", allowedMethods=" + allowedMethods + ", allowedHeaders="
					+ allowedHeaders + ", exposedHeaders=" + exposedHeaders + ", allowCredentials=" + allowCredentials
					+ ", maxAge=" + maxAge + "]";
		}

	}

}
