import React from 'react';
import Wrapper from "../../Wrapper/Wrapper";

function AuthenticationFailure() {
    return (
        <Wrapper>
            <h1>ВЫ ВВЕЛИ НЕВЕРНЫЕ ДАННЫЕ</h1>
            <p className="text-center text-light">
                <a href="/login" className="text-light">Попробовать еще раз</a>
            </p>
        </Wrapper>
    );
}

export default AuthenticationFailure;
