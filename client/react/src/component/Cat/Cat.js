import cat1 from '../../asset/cat.webp';
import cat2 from '../../asset/cat1.jpg';

function Cat(props){
    let img = null;

    switch (props.img) {
        case "cat1":
            img = cat1
            break
        case "cat2":
            img = cat2
            break
    }

    return (
        <div>
            <img src={img} width="10%" height="10%"/>
        </div>
    )
}

export default Cat;