import {useEffect, useState} from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

import { sendData } from "./api/SampleService"
import { SampleParams } from "./types/SampleParams"
import { ApiResponse } from "./types/ApiResponseTypes"

function App() {
    const [count, setCount] = useState<number>(0)
    const [name, setName] = useState<string>('');
    const [age, setAge] = useState<number>(0);


    const sampleCallApi = async (): Promise<void> => {
        let params: Partial<SampleParams> = {   //Partial > 파라미터 인터페이스 내 필드들이 항상 필수값일 필요는 없게 해줌
            name: "hm",
            age: count+1
        }
        let resp: ApiResponse  = await sendData(params);
        setName(resp.body.name);
        setAge(resp.body.age);
        setCount(resp.body.age);
    }

    const clickEvent = async () => {
        await sampleCallApi();
    }

    // const clickEvent2 = () => {
    //     void sampleCallApi();        // void => .then() 경고문 제거
    // }

    useEffect(() => {
        if(!name) return;

        setName(`${name} ${age}`)
    }, [age])

    return (
        <>
            <div>
                { name && <p>Name : {name}</p> }
                { age != 0 && <p>Age : {age}</p> }
            </div>
            <div>
                <a href="https://vite.dev" target="_blank">
                    <img src={viteLogo} className="logo" alt="Vite logo"/>
                </a>
                <a href="https://react.dev" target="_blank">
                    <img src={reactLogo} className="logo react" alt="React logo"/>
                </a>
            </div>
            <h1>Vite + React</h1>
            <div className="card">
                {/*<button onClick={() => setCount((count) => count + 1)}>*/}
                {/*    count is {count}*/}
                {/*</button>*/}
                <button onClick={clickEvent}>
                    count is {count}
                </button>
                <p>
                    Edit <code>src/App.tsx</code> and save to test HMR
                </p>
            </div>
            <p className="read-the-docs">
                Click on the Vite and React logos to learn more
            </p>
        </>
    )
}

export default App
