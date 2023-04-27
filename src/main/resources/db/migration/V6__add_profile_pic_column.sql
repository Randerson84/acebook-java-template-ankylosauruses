alter table users add column profile_picture varchar;

update users set profile_picture = '/Users/jameshalliday/gitDir/acebook/acebook-java-template-ankylosauruses/src/main/resources/images/Homer.png' where id in (1, 6);
update users set profile_picture = '/Users/jameshalliday/gitDir/acebook/acebook-java-template-ankylosauruses/src/main/resources/images/Bart.png' where id in (2, 7);
update users set profile_picture = '/Users/jameshalliday/gitDir/acebook/acebook-java-template-ankylosauruses/src/main/resources/images/Marge.png' where id in (3, 8);
update users set profile_picture = '/Users/jameshalliday/gitDir/acebook/acebook-java-template-ankylosauruses/src/main/resources/images/Lisa.png' where id in (4, 9);
update users set profile_picture = '/Users/jameshalliday/gitDir/acebook/acebook-java-template-ankylosauruses/src/main/resources/images/Maggie.png' where id in (5, 10);
