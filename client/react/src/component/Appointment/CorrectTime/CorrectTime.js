import React from 'react';
import Wrapper from "../../Wrapper/Wrapper";

function CorrectTime() {
    return (
        <Wrapper>
            <h1>ВЫ ЗАПИСАНЫ</h1>
            <p className="text-center text-light">
                <a href="/list_of_services" className="text-light">Создать еще одну запись</a>
            </p>
        </Wrapper>
    );
}

export default CorrectTime;
