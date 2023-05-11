import React from 'react';
import Wrapper from "../../Wrapper/Wrapper";

function UserExists(props) {
    return (
        <Wrapper>
            <h1>ПОЛЬЗОВАТЕЛЬ УЖЕ СУЩЕСТВУЕТ</h1>
            <p className="text-center text-light">
                <a href="/login" className="text-light">Войти в аккаунт</a>
            </p>
        </Wrapper>
    );
}

export default UserExists;
