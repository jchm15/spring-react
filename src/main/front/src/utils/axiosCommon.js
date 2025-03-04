import axios from "axios";

// Axios 인스턴스 생성
const apiClient = axios.create({
    // baseURL: "https://api.example.com",  // 기본 API URL
    baseURL: "http://localhost:8080",  // 기본 API URL
    headers: {
        "Content-Type": "application/json"
    }
});

// 요청 인터셉터 (예: 토큰 자동 추가)
apiClient.interceptors.request.use(
    (config) => {
        const token = localStorage.getItem("token"); // 로컬 스토리지에서 토큰 가져오기
        if (token) {
            config.headers.Authorization = `Bearer ${token}`;
        }
        return config;
    },
    (error) => Promise.reject(error)
);

// 응답 인터셉터 (예: 에러 핸들링)
apiClient.interceptors.response.use(
    (response) => response,
    (error) => {
        console.error("API Error:", error);
        if (error.response && error.response.status === 401) {
            alert("세션이 만료되었습니다. 다시 로그인하세요.");
            localStorage.removeItem("token");
            window.location.href = "/login";
        }
        return Promise.reject(error);
    }
);

// 공통 GET 요청 함수
export const get = async (url, params = {}) => {
    try {
        const response = await apiClient.get(url, { params });
        return response.data;
    } catch (error) {
        console.error("GET Error:", error);
        throw error;
    }
};

// 공통 POST 요청 함수
export const post = async (url, data = {}) => {
    try {
        const response = await apiClient.post(url, data);
        return response.data;
    } catch (error) {
        console.error("POST Error:", error);
        throw error;
    }
};

// 기본 apiClient도 export (필요하면 직접 사용 가능)
export default apiClient;
