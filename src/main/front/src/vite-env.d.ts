/// <reference types="vite/client" />

interface ImportMetaEnv {
    readonly VITE_API_BASE_URL: string;
    readonly VITE_APP_NAME: string;
    readonly VITE_APP_VERSION?: string; // 선택적 변수
}

interface ImportMeta {
    readonly env: ImportMetaEnv;
}
