import { post, get } from "../utils/axiosCommon"
import { SampleParams } from "../types/SampleParams"
// 사용 예시
import { ApiResponse } from "../types/ApiCommonTypes"

// GET 요청 예시
export const fetchData = async (params: Partial<SampleParams>): Promise<ApiResponse> => {
    try {
        return await get<ApiResponse>("/api/hello2", params);
    } catch (error) {
        console.error("Error fetching data", error);
    }
};

// POST 요청 예시
export const sendData = async (params: Partial<SampleParams>): Promise<ApiResponse> => {
    try {
        return await post<ApiResponse>("/api/hello", params);
    } catch (error) {
        console.error("Error sending data", error);
    }
};
