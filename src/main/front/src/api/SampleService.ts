import { post, get } from "../utils/axiosCommon"

// 사용 예시
interface Sample {
    id: number;
    name: string;
}

// GET 요청 예시
export const fetchData = async (params) => {
    try {
        return await get<Sample>("/api/hello2", params);
    } catch (error) {
        console.error("Error fetching data", error);
    }
};

// POST 요청 예시
export const sendData = async (params) => {
    try {
        return await post<Sample>("/api/hello", params);
    } catch (error) {
        console.error("Error sending data", error);
    }
};
